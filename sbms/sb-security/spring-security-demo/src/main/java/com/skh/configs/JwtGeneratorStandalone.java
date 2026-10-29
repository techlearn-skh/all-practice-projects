package com.skh.configs;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtGeneratorStandalone {

    // Must be at least 256 bits (32 bytes) for HS256. Use a real secret in production!
    // This is a Base64-encoded 32-byte key (example only — generate your own).
    private static final String SECRET_BASE64 = "dGhpcy1pcy1hLXN1cGVyLXNlY3JldC1rZXktMzJieXRlcyEh";
    private static final long EXPIRATION_MS = 3_600_000; // 1 hour

    public static void main(String[] args) {
        String username = (args.length > 0) ? args[0] : "kamal shaik";

        String token = generateToken(username);
        System.out.println("Generated JWT:");
        System.out.println(token);
        System.out.println("Validating JWT:");
        validateToken(token);
    }

    private static String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "ARCHITECT");
        claims.put("userId", 12345);

        Date now = new Date();
        LocalDateTime date = LocalDate.of(2026, 11, 10).atStartOfDay();
        Date expiry = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());

        SecretKey key = getSigningKey();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Validates the token's signature and expiration.
     * Returns true if valid; logs the reason and returns false otherwise.
     */
    public static boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getSigningKey())   // jjwt 0.12+ API
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            // If we get here, signature + expiration are valid
            System.out.println("✔ Signature OK");
            System.out.println("  Subject:  " + claims.getSubject());
            System.out.println("  Role:     " + claims.get("role"));
            System.out.println("  Issued:   " + claims.getIssuedAt());
            System.out.println("  Expires:  " + claims.getExpiration());
            return true;

        } catch (ExpiredJwtException e) {
            System.out.println("✘ Token expired at: " + e.getClaims().getExpiration());
        } catch (SignatureException e) {
            System.out.println("✘ Invalid signature — token may have been tampered with");
        } catch (MalformedJwtException e) {
            System.out.println("✘ Malformed token — not a valid JWT");
        } catch (UnsupportedJwtException e) {
            System.out.println("✘ Unsupported JWT format");
        } catch (IllegalArgumentException e) {
            System.out.println("✘ JWT string is null or empty");
        } catch (JwtException e) {
            // Catch-all for any other JJWT error
            System.out.println("✘ JWT error: " + e.getMessage());
        }
        return false;
    }
    private static SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_BASE64));
    }

}
