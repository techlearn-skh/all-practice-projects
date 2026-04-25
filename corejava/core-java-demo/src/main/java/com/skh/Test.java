package com.skh;

class Employee1 {
    int salary;
}

public class Test {
    public static void main(String[] args) {
        Employee1 emp = new Employee1();
        emp.salary = 1000;

        change(emp);

        System.out.println(emp.salary); // 5000
    }

    static void change(Employee1 e) {
//        e.salary = 5000;


        e = new Employee1(); // NEW OBJECT
        e.salary = 5000;
    }
}


