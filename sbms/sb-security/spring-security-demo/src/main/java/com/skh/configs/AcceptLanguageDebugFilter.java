package com.skh.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class AcceptLanguageDebugFilter implements WebFilter {

    private static final Logger log =
            LoggerFactory.getLogger(AcceptLanguageDebugFilter.class);

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            WebFilterChain chain) {

        String acceptLanguage = exchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.ACCEPT_LANGUAGE);

        log.warn(
                "Request URI: {}, Accept-Language: {}",
                exchange.getRequest().getURI().getPath(),
                acceptLanguage
        );

        return chain.filter(exchange);
    }
}
