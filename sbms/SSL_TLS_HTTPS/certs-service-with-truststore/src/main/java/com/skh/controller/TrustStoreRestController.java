package com.skh.controller;

import com.skh.models.UserVO;
import com.skh.services.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class TrustStoreRestController {
    /**
     * From browser only --> Send request to
     *  ==> http://localhost:9001/ename
     *  ==> http://localhost:9001
     *  ==> http://localhost:9001/ename?name=SKH
     */

    @Autowired
    private WebClientService  webClientService;

    @GetMapping("/")
    public ResponseEntity<Mono<String>> welcomeDownstreamService() {
       return ResponseEntity.ok(webClientService.welcomeDownstreamService());
    }

    @GetMapping("/ename")
    public ResponseEntity<Mono<String>> getCerts(@RequestParam(defaultValue = "KAMAL") String name){
        return ResponseEntity.ok(webClientService.welcomeDownstreamServiceWithName(name));
    }


}
