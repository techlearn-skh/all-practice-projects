package com.skh.service;

import com.skh.entities.EmployeeEntity;
import com.skh.models.EmployeeVO;
//import com.skh.repositories.EmployeeRepository;
import com.skh.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeVO dummyObject(){
        return new EmployeeVO(1,"AZAD Shaik", new Date(),12122d, true);
    }

    public String storeEmployee(EmployeeEntity employeeObj){
        employeeRepository.save(employeeObj);
        return "Employee Stored successfully with the name: "+ employeeObj.getEmpName();
    }

    public List<EmployeeEntity> fetchAllEmployees(){
        return  employeeRepository.findAll();
    }

    public Optional<EmployeeEntity> fetchEmployeesById(Integer eId){

        if(employeeExists(eId)){
            return  employeeRepository.findById(eId);
        }else {
            return Optional.empty();
        }
    }

    public String deleteEmployeeById(Integer employeeId){

        if(employeeExists(employeeId)){
            employeeRepository.deleteById(employeeId);
            return "Employee deleted successfully, employeeID: "+ employeeId;
        }else {
            return "Employee not found, employeeID: "+ employeeId;
        }
    }

    public Boolean employeeExists(Integer employeeId){
        return employeeRepository.existsById(employeeId);
    }


}
