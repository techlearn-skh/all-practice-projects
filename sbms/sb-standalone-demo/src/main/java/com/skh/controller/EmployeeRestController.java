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
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpId(1);
        employeeEntity.setEmpName("SKH");
        employeeEntity.setEmpSalary(232323d);
        employeeEntity.setEmpDOJ(new Date());
        employeeEntity.setEmpAddress("BVG");
        return  employeeEntity;
    }

    @PostMapping("/storeEmployee")
    public String storeEmployee(@RequestBody EmployeeEntity employeeObj){
        employeeObj.setEmpDOJ(new Date());
         return employeeService.storeEmployee(employeeObj);
    }

    @GetMapping("/fetchAllEmployees")
    public Set<EmployeeVO> fetchAllEmployees(){
        return  employeeService.fetchAllEmployees();
    }


}
