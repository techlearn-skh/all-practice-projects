package com.skh.services;

import com.skh.entities.UserEntity;
import com.skh.repoitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class CustomUserDetailsService implements ReactiveUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {

        return Mono.fromCallable(() ->
                        userRepository.findByUsername(username)
                                .orElseThrow(() ->
                                        new UsernameNotFoundException(
                                                "User not found: " + username)))
                .subscribeOn(Schedulers.boundedElastic())
                .map(user -> User
                        .withUsername(user.getUsername())
                        .password(user.getPassword())
                        .authorities("ROLE_USER")
                        .build());
    }
}