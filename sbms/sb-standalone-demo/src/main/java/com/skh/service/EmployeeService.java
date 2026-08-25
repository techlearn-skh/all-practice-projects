package com.skh.service;

import com.skh.models.EmployeeVO;
//import com.skh.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeService {

/*    @Autowired
    private EmployeeRepository employeeRepository;*/


    private Set<EmployeeVO> employeeVOSet = new HashSet<>();

    public EmployeeVO dummyObject(){
        return new EmployeeVO(1,"AZAD Shaik", new Date(),12122d, true);
    }

    public String storeEmployee(EmployeeVO employeeObj){
        employeeVOSet.add(employeeObj);
        return "Employee Stored successfully with the name: "+ employeeObj.getEmpName();
    }

    public Set<EmployeeVO> fetchAllEmployees(){
        return  employeeVOSet;
    }


}
