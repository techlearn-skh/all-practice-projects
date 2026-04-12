package com.skh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OCPDemoController {

    private static final Logger logger = LoggerFactory.getLogger(OCPDemoController.class);

    @Autowired
    private Environment environment;

    @GetMapping("/")
    public String welcomeMessage() {
        logger.info("Hi welcome to OCPDemoController, port: " + environment.getProperty("server.port"));
        logger.debug("Hi welcome to OCPDemoController, port: " + environment.getProperty("server.port"));
        return "Hi welcome to OCPDemoController, port: " + environment.getProperty("server.port");
    }

    @GetMapping("/fullName")
    public String fetchFullName(@RequestParam String firstName,
                                @RequestParam String lastName) {
        logger.info(String.format("Hi your full name is %s %s, port: %s", firstName, lastName, environment.getProperty("server.port")));
        logger.debug(String.format("Hi your full name is %s %s, port: %s", firstName, lastName, environment.getProperty("server.port")));
        return String.format("Hi your full name is %s %s, port: %s", firstName, lastName, environment.getProperty("server.port"));
    }
    // http://localhost:9001/fullName?firstName=azad&lastName=shaik
}
