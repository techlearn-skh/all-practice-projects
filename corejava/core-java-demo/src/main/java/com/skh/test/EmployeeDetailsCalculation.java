package com.skh.test;

public class EmployeeDetailsCalculation {

    public void fetchEmployeeSalary(IEmployeeService iEmployeeService){
        iEmployeeService.calculateSalary();
    }
    public void fetchEmployeeDetails(IEmployeeService iEmployeeService){
        iEmployeeService.showEmployeeDetails();
    }

}
