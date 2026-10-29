package com.skh.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(csrf -> csrf.disable()) // Disable CSRF if needed
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/saveUser").permitAll()
                        .pathMatchers("/dummyUser").permitAll()
                        .pathMatchers("/authenticateUser").permitAll()
                        .pathMatchers("/authenticateUserAndGenerateJWTToken").permitAll()
//                        .pathMatchers("/**").permitAll()
                                .pathMatchers(
                                        "/swagger-ui.html",
                                        "/swagger-ui/**",
                                        "/v3/api-docs/**"
                                ).permitAll()
                        .anyExchange().authenticated()
                )
                .httpBasic(httpBasic -> {}) // Enable basic auth
                .formLogin(formLogin -> {}) // Enable form login
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Recommended standard
    }

    // Explicitly define the Authentication Manager using your custom service and encoder
    @Bean
    public ReactiveAuthenticationManager authenticationManager(ReactiveUserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {

        UserDetailsRepositoryReactiveAuthenticationManager manager =
                new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService);
        manager.setPasswordEncoder(passwordEncoder);
        return manager;
    }
}
