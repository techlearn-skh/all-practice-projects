package com.skh.propertycustomvalidation;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class PropertyCustomValidationController {

    @PostMapping
    public ResponseEntity<String> createEmployee(
            @Valid @RequestBody EmployeeRequest request) {
        return ResponseEntity.ok("Employee created: " + request.getEmployeeName()
        );
    }
}
