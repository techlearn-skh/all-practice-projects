package com.skh.controller;

import com.skh.entities.EmployeeEntity;
import com.skh.service.EmployeeService;
import com.skh.models.EmployeeVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ObjectNode;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/emp")
@Tag(name = "EmployeeRestController API", description = "EmployeeRestController Operations")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    @Operation(summary = "Welcome message", description = "Returns a welcome message with host/pod info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response")
    })
    @GetMapping("/dummy")
    public EmployeeVO dummy(){
        return  employeeService.dummyObject();
    }

    @Operation(summary = "Welcome message", description = "Returns a welcome message with host/pod info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response")
    })
    @GetMapping("/entityDummy")
    public EmployeeEntity entityDummy(@RequestParam String test){
        System.out.println(test);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpId(1);
        employeeEntity.setEmpName("SKH");
        employeeEntity.setEmpSalary(232323d);
        employeeEntity.setEmpDOJ(new Date());
        employeeEntity.setEmpAddress("BVG");
        objectMapperPractice(employeeEntity);
        return  employeeEntity;
    }

    @Operation(summary = "Welcome message", description = "Returns a welcome message with host/pod info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response")
    })
    @PostMapping("/storeEmployee")
    public String storeEmployee(@RequestBody EmployeeEntity employeeObj){
        employeeObj.setEmpDOJ(new Date());
         return employeeService.storeEmployee(employeeObj);
    }

    @Operation(summary = "Welcome message", description = "Returns a welcome message with host/pod info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response")
    })
    @GetMapping("/fetchAllEmployees")
    public List<EmployeeEntity> fetchAllEmployees(){
        return  employeeService.fetchAllEmployees();
    }

    private void objectMapperPractice(EmployeeEntity employeeEntity){
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.convertValue(employeeEntity, JsonNode.class);
        ((ObjectNode)jsonNode).set("empPetName",objectMapper.convertValue("kamal", JsonNode.class));
        System.out.println(jsonNode);
    }


    @Operation(summary = "Welcome message", description = "Returns a welcome message with host/pod info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response")
    })
    @GetMapping("/fetchEmpById")
    public Optional<EmployeeEntity> fetchEmployeesById(@RequestParam Integer eId){
        return  employeeService.fetchEmployeesById(eId);
    }

    @Operation(summary = "Welcome message", description = "Returns a welcome message with host/pod info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response")
    })
    @DeleteMapping("/deleteEmployeeById")
    public String deleteEmployeeById(@RequestParam Integer employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }
}
