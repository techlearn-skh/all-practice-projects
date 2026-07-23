package com.skh.annotations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class SbiCreditCard {
    public void limit(){
        System.out.println("Limit is 5Laks");
    }
    public void dueAmount(){
        System.out.println("Due amount is: 2Laks");
    }
}
