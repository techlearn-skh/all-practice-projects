package com.skh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {

    @Autowired
    private WebClient webClient;

    public Mono<String> welcomeDownstreamService() {
        return webClient.get()
                .uri("/")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> welcomeDownstreamServiceWithName(String name) {
        return webClient.get()
                .uri("/ename?name=" + name)
                .retrieve()
                .bodyToMono(String.class);
    }
}
