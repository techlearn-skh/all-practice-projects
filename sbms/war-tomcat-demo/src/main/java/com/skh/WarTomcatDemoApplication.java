package com.skh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WarTomcatDemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WarTomcatDemoApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WarTomcatDemoApplication.class);
	}

	@GetMapping(value = "/")
	public String hello() {
		return "Hello World from Tomcat";
	}

	@GetMapping(value = "/emp")
	public String helloEmp() {
		return "Hello Empoyee welcome to Tomcat Demo";
	}


}
