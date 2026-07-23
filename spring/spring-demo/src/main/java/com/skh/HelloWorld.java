package com.skh;

public class HelloWorld {
    private String message;
    private Address address;
    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "message='" + message + '\'' +
                ", address=" + address +
                ", employeeService=" + employeeService +
                '}';
    }
}