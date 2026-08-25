package com.skh.controller;

import com.skh.entities.EmployeeEntity;
import com.skh.service.EmployeeService;
import com.skh.models.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public EmployeeEntity entityDummy(){
        return  new EmployeeEntity();
    }

    @PostMapping("/storeEmployee")
    public String storeEmployee(@RequestBody EmployeeVO employeeObj){
         return employeeService.storeEmployee(employeeObj);
    }

    @GetMapping("/fetchAllEmployees")
    public Set<EmployeeVO> fetchAllEmployees(){
        return  employeeService.fetchAllEmployees();
    }


}
