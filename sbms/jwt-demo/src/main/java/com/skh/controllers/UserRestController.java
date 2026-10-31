package com.skh.controllers;

import com.skh.entities.UserEntity;
import com.skh.services.JwtService;
import com.skh.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

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
        return userService.registerUser(userEntity.getUsername(), userEntity.getPassword(), userEntity.getRole());
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
    @PostMapping("/login")
    public Mono<ResponseEntity<Map<String, String>>> generateToken(@RequestBody UserEntity request) {
        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()))
                .flatMap(authentication -> {
                    // 1. Authentication successful, get the UserDetails principal
                    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

                    // 2. Generate the JWT token
                    String token = jwtService.generateToken(userDetails);

                    // 3. Return the token in the response body (HTTP 200 OK)
                    return Mono.just(ResponseEntity.ok(Map.of("token", token)));
                })
                // 4. Handle authentication failure (Bad credentials, user not found, etc.)
                .onErrorResume(error -> {
                    // Fix: Wrap the error message in a Map to match the signature
                    return Mono.just(ResponseEntity
                            .status(HttpStatus.UNAUTHORIZED)
                            .body(Map.of("error", "Invalid username or password")));
                });
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



    @PostMapping("/test")
    public Mono<Boolean> generateTokenTest(@RequestBody UserEntity request) {

        return authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                )
                .map(Authentication::isAuthenticated)
                .doOnError(Throwable::printStackTrace)
                .onErrorReturn(false);
    }


    // this endpoint is not configured in CONFIG class. So we need to call this method by passing Bearer token.
    @GetMapping("/testWithToken")
    private Mono<String> testWithToken() {
        return Mono.just("Token is valid");
    }

}
