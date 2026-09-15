package com.skh.propertycustomvalidation;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@Tag(name = "PropertyCustomValidationController API", description = "PropertyCustomValidationController Operations")
public class PropertyCustomValidationController {

    @Operation(summary = "Welcome message", description = "Returns a welcome message with host/pod info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response")
    })
    @PostMapping
    public ResponseEntity<String> createEmployee(
            @Valid @RequestBody EmployeeRequest request) {
        return ResponseEntity.ok("Employee created: " + request.getEmployeeName()
        );
    }
}
