package com.skh.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
//@Component
public class JwtServiceAdvanced { // NOT USING THIS CLASS.

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";
    private static final String CLAIM_ROLES = "roles";
    private static final String CLAIM_TOKEN_ID = "jti";
    private static final String CLAIM_TOKEN_TYPE = "type";
    private static final String CLAIM_USER_ID = "uid";

    public enum TokenType {
        ACCESS, REFRESH, PASSWORD_RESET, EMAIL_VERIFICATION
    }

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.access-token-expiration-ms:900000}")     // 15 min default
    private long accessTokenExpirationMs;

    @Value("${jwt.refresh-token-expiration-ms:604800000}")  // 7 days default
    private long refreshTokenExpirationMs;

    @Value("${jwt.issuer:skh-services}")
    private String issuer;

    @Value("${jwt.clock-skew-seconds:30}")
    private long clockSkewSeconds;

    // Simple in-memory blacklist; replace with Redis in production
    private final Set<String> revokedTokenIds = ConcurrentHashMap.newKeySet();

    private final SecureRandom secureRandom = new SecureRandom();

    // ------------------------------------------------------------------
    //  Token Generation
    // ------------------------------------------------------------------

    public String generateAccessToken(UserDetails userDetails) {
        return buildToken(userDetails, accessTokenExpirationMs, TokenType.ACCESS, Collections.emptyMap());
    }

    public String generateAccessToken(UserDetails userDetails, Map<String, Object> extraClaims) {
        return buildToken(userDetails, accessTokenExpirationMs, TokenType.ACCESS, extraClaims);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return buildToken(userDetails, refreshTokenExpirationMs, TokenType.REFRESH, Collections.emptyMap());
    }

    public String generateToken(UserDetails userDetails, TokenType type, long expirationMs,
                                Map<String, Object> extraClaims) {
        return buildToken(userDetails, expirationMs, type, extraClaims);
    }

    private String buildToken(UserDetails userDetails, long expirationMs,
                              TokenType type, Map<String, Object> extraClaims) {

        Instant now = Instant.now();
        Instant expiry = now.plusMillis(expirationMs);

        Map<String, Object> claims = new HashMap<>(extraClaims);
        claims.put(CLAIM_TOKEN_TYPE, type.name());
        claims.put(CLAIM_ROLES, userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        return Jwts.builder()
                .claims(claims)
                .id(UUID.randomUUID().toString())
                .subject(userDetails.getUsername())
                .issuer(issuer)
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiry))
                .notBefore(Date.from(now))
                .signWith(getSigningKey())
                .compact();
    }

    // ------------------------------------------------------------------
    //  Token Parsing / Validation
    // ------------------------------------------------------------------

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .requireIssuer(issuer)
                .clockSkewSeconds(clockSkewSeconds)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        return resolver.apply(extractAllClaims(token));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractTokenId(String token) {
        return extractClaim(token, Claims::getId);
    }

    public TokenType extractTokenType(String token) {
        String type = extractClaim(token, c -> c.get(CLAIM_TOKEN_TYPE, String.class));
        return type == null ? TokenType.ACCESS : TokenType.valueOf(type);
    }

    @SuppressWarnings("unchecked")
    public List<String> extractRoles(String token) {
        return extractClaim(token, c -> (List<String>) c.getOrDefault(CLAIM_ROLES, Collections.emptyList()));
    }

    public Instant extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration).toInstant();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            Claims claims = extractAllClaims(token);

            if (!claims.getSubject().equals(userDetails.getUsername())) {
                return false;
            }
            if (isTokenRevoked(claims)) {
                return false;
            }
            return !isTokenExpired(token);
        } catch (JwtException | IllegalArgumentException ex) {
            log.debug("Token validation failed: {}", ex.getMessage());
            return false;
        }
    }

    public boolean isTokenValid(String token, UserDetails userDetails, TokenType expectedType) {
        return isTokenValid(token, userDetails) && extractTokenType(token) == expectedType;
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).isBefore(Instant.now());
    }

    public boolean isTokenRevoked(Claims claims) {
        String jti = claims.getId();
        return jti != null && revokedTokenIds.contains(jti);
    }

    // ------------------------------------------------------------------
    //  Revocation
    // ------------------------------------------------------------------

    public void revokeToken(String token) {
        try {
            Claims claims = extractAllClaims(token);
            if (claims.getId() != null) {
                revokedTokenIds.add(claims.getId());
                log.info("Revoked token jti={}", claims.getId());
            }
        } catch (JwtException ex) {
            log.warn("Cannot revoke invalid token: {}", ex.getMessage());
        }
    }

    public void purgeExpiredRevokedTokens() {
        // Cleanup routine - call periodically
        revokedTokenIds.removeIf(jti -> {
            // In real impl, store jti -> expiry map, delete if expired
            return false;
        });
    }

    // ------------------------------------------------------------------
    //  Request Extraction
    // ------------------------------------------------------------------

    public Optional<String> resolveToken(ServerWebExchange exchange) {
        String header = exchange.getRequest().getHeaders().getFirst(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(header) && header.startsWith(BEARER_PREFIX)) {
            return Optional.of(header.substring(BEARER_PREFIX.length()));
        }
        return Optional.empty();
    }

    // ------------------------------------------------------------------
    //  Helpers
    // ------------------------------------------------------------------

    private SecretKey getSigningKey() {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        if (keyBytes.length < 32) {
            throw new IllegalStateException("JWT secret must be at least 256 bits (32 bytes)");
        }
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isWellFormed(String token) {
        try {
            extractAllClaims(token);
            return true;
        } catch (ExpiredJwtException e) {
            return true; // structurally valid
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getTokenFingerprint(String token) {
        try {
            return Integer.toHexString(Arrays.hashCode(token.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            return "invalid";
        }
    }
}