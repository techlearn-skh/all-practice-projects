package com.skh.controller;

import com.skh.entities.EmployeeEntity;
import com.skh.service.EmployeeService;
import com.skh.models.EmployeeVO;
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
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/dummy")
    public EmployeeVO dummy(){
        return  employeeService.dummyObject();
    }

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

    @PostMapping("/storeEmployee")
    public String storeEmployee(@RequestBody EmployeeEntity employeeObj){
        employeeObj.setEmpDOJ(new Date());
         return employeeService.storeEmployee(employeeObj);
    }

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


    @GetMapping("/fetchEmpById")
    public Optional<EmployeeEntity> fetchEmployeesById(@RequestParam Integer eId){
        return  employeeService.fetchEmployeesById(eId);
    }


}
