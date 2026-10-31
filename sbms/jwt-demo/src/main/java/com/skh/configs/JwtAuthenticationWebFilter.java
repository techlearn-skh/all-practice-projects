package com.skh.configs;

import com.skh.services.JwtService;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class JwtAuthenticationWebFilter implements WebFilter {

    private final JwtService jwtService;

    private final ReactiveUserDetailsService userDetailsService;

    public JwtAuthenticationWebFilter(
            JwtService jwtService,
            ReactiveUserDetailsService userDetailsService) {

        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            WebFilterChain chain) {

        // Step 1: Extract Authorization header
        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);

        // Step 2: Check Bearer token
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return chain.filter(exchange);
        }

        // Step 3: Extract JWT
        String token = authHeader.substring(7);

        final String username;

        try {

            // Step 4: Extract username from JWT
            username = jwtService.extractUsername(token);

        } catch (JwtException | IllegalArgumentException exception) {

            return unauthorized(exchange);
        }

        // Step 5: Load user details
        return userDetailsService.findByUsername(username)

                // Convert empty result into Optional.empty()
                .map(Optional::of)
                .defaultIfEmpty(Optional.empty())

                .flatMap(optionalUser -> {

                    // Step 6: Check user existence
                    if (optionalUser.isEmpty()) {
                        return unauthorized(exchange);
                    }

                    UserDetails userDetails = optionalUser.get();

                    try {

                        // Step 7: Validate JWT
                        if (!jwtService.isTokenValid(token, userDetails)) {
                            return unauthorized(exchange);
                        }

                    } catch (JwtException | IllegalArgumentException exception) {

                        return unauthorized(exchange);
                    }

                    // Step 8: Create authenticated object
                    Authentication authentication =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );

                    // Step 9: Continue request execution
                    return chain.filter(exchange)
                            .contextWrite(
                                    ReactiveSecurityContextHolder
                                            .withAuthentication(authentication)
                            );
                });
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange) {

        exchange.getResponse()
                .setStatusCode(HttpStatus.UNAUTHORIZED);

        return exchange.getResponse().setComplete();
    }
}