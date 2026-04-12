package com.skh;


import java.util.Date;

public class App {
    public static void main(String[] args) {
        EmployeeVO e1 = new EmployeeVO(12, "AZAD", new Date(), 1234d, true);
        EmployeeVO e2 = new EmployeeVO(121, "AZAD", new Date(), 1234d, true);

//        e1.setEmpName("Kamal");

//        System.out.println(e1.equals(e2));
//        System.out.println(e1.getEmpName());
//        System.out.println(e2.getEmpName());

        String name1 = "azad";
        String name2 = "azad";

        System.out.println(name1.equals(name2));
    }
}
