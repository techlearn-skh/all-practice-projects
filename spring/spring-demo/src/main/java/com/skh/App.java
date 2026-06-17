package com.skh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		// parent p = new child();
		Object eService = context.getBean("eService");
		EmployeeService employeeService = (EmployeeService)eService;

		System.out.println(employeeService.employeeDetails());
        System.out.println("Welcome to Spring Project...!");

	}
}