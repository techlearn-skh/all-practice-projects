package com.skh.configs;

import org.springframework.boot.webclient.autoconfigure.WebClientSsl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(
            WebClient.Builder builder,
            WebClientSsl ssl) {

        return builder
                .apply(ssl.fromBundle("my-downstream-client"))
                .baseUrl("https://localhost:9002")
                .build();
    }
}