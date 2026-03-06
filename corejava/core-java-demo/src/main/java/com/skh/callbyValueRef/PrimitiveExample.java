package com.skh.callbyValueRef;

public class PrimitiveExample {
    public static void main(String[] args) {
        int x = 10;
        System.out.println("Before modify: " + x); // 10
        modifyPrimitive(x);
        System.out.println("After modify: " + x);  // 10 (unchanged!)
    }

    static void modifyPrimitive(int num) {
        num = 20;  // Only modifies the local copy
        System.out.println("Inside method: " + num); // 20
    }
}