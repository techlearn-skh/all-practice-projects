package com.skh.propertycustomvalidation;


public class EmployeeRequest {

    @CustomStringConstraint(message = "Employee name cannot be null or undefined")
    private String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}