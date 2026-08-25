package com.skh.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {

        return WebClient.builder()
                .filter((request, next) -> {
                    System.out.println("WebClient filter called...!!!");
                    return next.exchange(request);
                })
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors()
                .add(new HttpReqInterceptor());

        return restTemplate;
    }
}