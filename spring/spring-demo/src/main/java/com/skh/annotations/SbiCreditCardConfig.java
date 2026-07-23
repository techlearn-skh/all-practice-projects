package com.skh.annotations;


import com.skh.EmployeeService;
import com.skh.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration// gving
public class SbiCreditCardConfig {

    @Bean//giving instructions.
    public SbiCreditCard m51(){
        return new SbiCreditCard();
    }


}
