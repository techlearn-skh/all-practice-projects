package com.skh;


import java.util.Date;

public class Employee {

    private String empName;
    private Integer empId;

    public Employee() {
    }

    public Employee(int abs, String substring, Date date, double ceil, boolean b) {

    }



    public void setEmpName(String empName) {
        System.out.println(empName);
        this.empName = empName;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }


    public void displayDetails(){
        System.out.println(String.format("%s : %s", this.empId, this.empName));
    }

    void displayDetails1(){
        System.out.println(String.format("%s : %s", this.empId, this.empName));
    }

    void displayDet12ils(){
        System.out.println(String.format("%s : %s", this.empId, this.empName));
    }

    void dis34playDetails(){
        System.out.println(String.format("%s : %s", this.empId, this.empName));
    }

    void disp45layDetails(){
        System.out.println(String.format("%s : %s", this.empId, this.empName));
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empId=" + empId +
                '}';
    }
}
