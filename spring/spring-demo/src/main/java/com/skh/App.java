package com.skh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	// parent p = new child();
		Object eService = context.getBean("eService");
		EmployeeService employeeService = (EmployeeService)eService;
		System.out.println(employeeService);


/*		Address address = new Address();
		address.setCountry("IND");
		address.setState("AP");

		EmployeeService employeeService = new EmployeeService("azad", 12,address );
		System.out.println(employeeService.employeeDetails());*/



	}
}