package com.skh;


import com.skh.interfaces.AnimalInterface;

public class Test {
    public static void main(String[] args) {
    // void  m1(int age, String village);

        AnimalInterface ref = (int age, String village) -> System.out.println("Welcome to Java-8");
        ref.m1(1,"Welcome to Java-8");


    }
}





