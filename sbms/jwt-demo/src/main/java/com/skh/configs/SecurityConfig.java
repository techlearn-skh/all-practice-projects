package com.skh.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationWebFilter jwtAuthenticationWebFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(
            ServerHttpSecurity http) {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(exchange -> exchange
                                .pathMatchers("/user/dummyUser").permitAll()
                                .pathMatchers("/user/register").permitAll()
                                .pathMatchers("/user/generateTokenByUserNameAndPassword").permitAll()
                                .pathMatchers("/user/getTokenByUNameAndPwdReturnInFilterHeader").permitAll()
                                .pathMatchers("/user/test").permitAll()
                                .pathMatchers("/user/authenticateUser").permitAll()
                                .pathMatchers("/user/authenticateUserAndGenerateJWTToken").permitAll()
                                .pathMatchers(
                                        "/swagger-ui.html",
                                        "/swagger-ui/**",
                                        "/v3/api-docs/**"
                                ).permitAll()
//                        .pathMatchers("/api/admin/**").hasRole("ADMIN")
//                        .pathMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")
                                .anyExchange().authenticated()
                )
                .addFilterAt(jwtAuthenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .build();
    }

    /**
     * When we start the server that time itself, below objject created and stored in spring IOC container context.
     *
     * @param userDetailsService
     * @param passwordEncoder
     * @return
     */
    @Bean
    public ReactiveAuthenticationManager reactiveAuthenticationManager(ReactiveUserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        UserDetailsRepositoryReactiveAuthenticationManager manager = new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService);
        manager.setPasswordEncoder(passwordEncoder);
        return manager;
    }


}
