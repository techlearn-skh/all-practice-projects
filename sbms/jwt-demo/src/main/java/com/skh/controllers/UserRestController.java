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

/*    @PostMapping("/login")
    public Mono<String> login(@RequestBody UserEntity request) {
        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()))
                .map(authentication -> jwtService.generateToken((UserDetails) authentication.getPrincipal()));
    }*/

    /*@PostMapping("/login")
    public Mono<String> login(@RequestBody UserEntity request) {

        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()))
                .map(authentication -> "Authentication successful");
    }*/

    @PostMapping("/authenticateUser")
    public Mono<Boolean> login(@RequestBody UserEntity request) {

        return authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                )
                .map(Authentication::isAuthenticated)
                .onErrorReturn(false);
    }



    @GetMapping("/dummyUser")
    private Mono<UserEntity> dummyUser() {
        UserEntity user = new UserEntity();
        user.setUsername("test_user");
        user.setPassword("");
        user.setRole("USER");
        return Mono.just(user);
    }

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserEntity userEntity) {
        return userService.registerUser(userEntity.getUsername(), userEntity.getPassword());
    }
}
