package com.skh.controllers;

import com.skh.entities.UserEntity;
import com.skh.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReactiveAuthenticationManager authenticationManager;

    @PostMapping("/saveUser")
    public UserEntity saveUserCredentials(@RequestBody UserEntity userEntity) {
        return userService.saveUserCredentials(userEntity);
    }

    @GetMapping("/dummyUser")
    public UserEntity dummyUser(UserEntity userEntity) {
        userEntity.setId(1L);
        userEntity.setUsername("Dummy User");
        userEntity.setPassword("test123");
        return userEntity;
    }

    @PostMapping("/authenticateUser")
    public Mono<Boolean> login(@RequestBody UserEntity request) {
        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()))
                .map(Authentication::isAuthenticated)
                .onErrorReturn(false);
    }
    @PostMapping("/authenticateUserAndGenerateJWTToken")
    public Mono<String> authenticateUserAndGenerateJWTToken(@RequestBody UserEntity request) {
        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()))
                .map(authentication -> generateToken((UserDetails) authentication.getPrincipal()));
    }
    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSigningKey())
                .compact();
    }

    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                "spring-security-demo-secret-key-spring-security-demo-secret-key".getBytes(StandardCharsets.UTF_8)
        );
    }


}
