package com.skh;

import com.skh.annotations.SbiCreditCard;
import com.skh.annotations.SbiCreditCardConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App{


	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SbiCreditCardConfig.class);

		SbiCreditCard creditCard = ctx.getBean(SbiCreditCard.class);
		creditCard.limit();


	}


}

