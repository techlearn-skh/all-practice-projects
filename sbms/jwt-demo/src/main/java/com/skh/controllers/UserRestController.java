package com.skh.controllers;

import com.skh.entities.UserEntity;
import com.skh.services.JwtService;
import com.skh.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReactiveAuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    /**
     * First always register one use by passing username and password.
     * @param userEntity
     * @return
     */
    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserEntity userEntity) {
        return userService.registerUser(userEntity.getUsername(), userEntity.getPassword());
    }

    @GetMapping("/dummyUser")
    private Mono<UserEntity> dummyUser() {
        UserEntity user = new UserEntity();
        user.setUsername("test_user");
        user.setPassword("");
        user.setRole("USER");
        return Mono.just(user);
    }

    /**
     * Below just we are testing by passing username and passowrd, how authentication is working. Testing method.
     * @param request
     * @return
     */
    @PostMapping("/authenticateUser")
    public Mono<Boolean> login(@RequestBody UserEntity request) {
        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()))
                .map(Authentication::isAuthenticated)
                .onErrorReturn(false);
    }

    /**
     * Below we are passing username and passowrd, upon authentication generating JWT  token and returning to user.
     * Next request if you want to send to any other endpoints which are non-public we need to use of that token generated.
     * @param request
     * @return
     */
    @PostMapping("/authenticateUserAndGenerateJWTToken")
    public Mono<String> authenticateUserAndGenerateJWTToken(@RequestBody UserEntity request) {
        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()))
                .map(authentication -> jwtService.generateToken((UserDetails) authentication.getPrincipal()));
    }

    /*@PostMapping("/login")
    public Mono<String> login(@RequestBody UserEntity request) {

        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()))
                .map(authentication -> "Authentication successful");
    }*/








}
