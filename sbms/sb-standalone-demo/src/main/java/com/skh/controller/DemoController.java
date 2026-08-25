package com.skh.controller;

import com.skh.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
/*

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/welcome/{eName}/{village}/{mandal}")
    String welcomeMessage(@PathVariable String eName, @PathVariable String village
    ,@PathVariable String mandal){
        return String.format("Hi %s Weclome to Spring boot: %s - %s", eName, village, mandal);
    }
// http://localhost:8080/welcome/azad/MVG/TNSP

    @GetMapping("/")
    public ResponseEntity<String> getAllEmployees() {

        Mono<String> employee = employeeService.getEmployee();
        return ResponseEntity.ok("Welcome..");
    }
    @GetMapping("/aa")
    public Mono<ResponseEntity<String>> getAllEmployeesMono() {

        return employeeService.getEmployee()
                .map(employee -> {
                    System.out.println(employee);
                    return ResponseEntity.ok(employee);
                });
    }
    @GetMapping("/abc")
    public ResponseEntity<String> getAllEmployees12() {
        return ResponseEntity.ok("Welcome....abc");
    }
}
*/
