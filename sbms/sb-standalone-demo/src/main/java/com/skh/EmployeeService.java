package com.skh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

//@Service
public class EmployeeService {

//    @Autowired
    private WebClient webClient;

//    @Autowired
    private RestTemplate restTemplate;


    public EmployeeService(WebClient webClient, RestTemplate restTemplate) {
        this.webClient = webClient;
        this.restTemplate = restTemplate;
    }




  /*  public EmployeeService(RestTemplate restTemplate) {
        RestTemplate restTemplate
    }*/

    public String getEmployeeUsingRestTemplate() {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", String.class
        );
    }

    public Mono<String> getEmployee() {

        getEmployeeUsingRestTemplate();

        return webClient
                .get()
                .uri("https://jsonplaceholder.typicode.com/todos/1")
                .retrieve()
                .bodyToMono(String.class);
    }
}