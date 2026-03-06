package com.skh.controllers;


import com.skh.models.EmployeeVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TestController{
    /*

{empId: 84, empName: '0ef28254', empDOJ: '2026-02-01T01:18:11.443Z', empSalary: 23625, isPermenentEmp: false}
     */


    List<EmployeeVO> allEmployeesList = new ArrayList<>();

    @GetMapping
    public String getHelloWorld(){
        return "Hello.. Spring boot 4XX!!!!";
    }

    @GetMapping("/fetch-employee")
    public EmployeeVO dummyEmployee(){
        return new EmployeeVO(1,"AA",new Date(),1212d,true);
    }

    @GetMapping("/fetch-all-employees1")
    public List<EmployeeVO> fetchAllEmployees(){
        List<EmployeeVO> employeeVOSList = EmployeeVO.fetchAllEmployeesCustomized();
        employeeVOSList.get(0).setEmpId(null);
        allEmployeesList.addAll(employeeVOSList);
        return employeeVOSList;
    }

    @GetMapping("/fetch-all-employees")
    public ResponseEntity<List<EmployeeVO>> fetchAllEmployeesWithStatus(){
        List<EmployeeVO> employeeVOSList = EmployeeVO.fetchAllEmployeesCustomized();
        employeeVOSList.get(0).setEmpId(null);
        allEmployeesList.addAll(employeeVOSList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allEmployeesList);
    }

    @PostMapping("/store-employee")
    public EmployeeVO storeWorker(@RequestBody EmployeeVO employee){
        System.out.println(employee);
        return employee;
    }

    @PostMapping("/store-employee-sql")
    public EmployeeVO storeWorkerInSqlDB(@RequestBody EmployeeVO employee){
        return employee;
    }

    @PostMapping("/store-employee-extended/{empId}")
    public EmployeeVO storeWorkerExtended(@RequestBody EmployeeVO employee, @PathVariable Integer empId,
                                          @RequestParam String empName, @RequestParam String empCompanyName,
                                          @RequestHeader String token){
        System.out.println("empId: "+ empId);
        System.out.println("empName: "+ empName);
        System.out.println("empCompanyName: "+ empCompanyName);
        System.out.println("customHeader: "+ token);
        return employee;
    }

    @PostMapping("/searchbyid/{empId}")
    public Integer searchByEmployeeId(@PathVariable Integer employeeId){
        System.out.println(employeeId);
        return employeeId;
    }
}
