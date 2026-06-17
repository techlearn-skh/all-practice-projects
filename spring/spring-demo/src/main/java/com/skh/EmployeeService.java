package com.skh;

public class EmployeeService {
    private String empName;
    private Integer empId;


    public String employeeDetails() {
        return String.format("Employee details are:  %s- %d", empName, empId);
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "EmployeeService{" +
                "empName='" + empName + '\'' +
                ", empId=" + empId +
                '}';
    }
}
