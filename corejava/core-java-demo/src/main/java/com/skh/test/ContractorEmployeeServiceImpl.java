package com.skh.test;

public class ContractorEmployeeServiceImpl implements  IEmployeeService{
    @Override
    public void showEmployeeDetails() {
        System.out.println("ContractorEmployeeServiceImpl.java --> showEmployeeDetails()");

    }

    @Override
    public void calculateSalary() {
        System.out.println("ContractorEmployeeServiceImpl.java --> calculateSalary()");

    }
}
