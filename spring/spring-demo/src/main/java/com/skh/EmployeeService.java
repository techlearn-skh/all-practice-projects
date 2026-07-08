package com.skh;

public class EmployeeService {
    private String empName;
    private Integer empId;
    private Address  address;

    public EmployeeService(String empName, Integer empId, Address  address ){
        this.empName = empName;
        this.empId = empId;
        this.address = address;
    }


    public String employeeDetails() {
        return String.format("Employee details are:  %s- %d - %s", empName, empId, address);
    }

    @Override
    public String toString() {
        return "EmployeeService{" +
                "empName='" + empName + '\'' +
                ", empId=" + empId +
                ", address=" + address +
                '}';
    }
}
