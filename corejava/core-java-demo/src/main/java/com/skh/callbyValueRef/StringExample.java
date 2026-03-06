package com.skh.callbyValueRef;

public class StringExample {
    public static void main(String[] args) {
        String text = "Hello";
        System.out.println("Before modify: " + text); // Hello

        modifyString(text);
        System.out.println("After modify: " + text);  // Hello (unchanged!)
    }

    static void modifyString(String str) {
        str = str + " World";  // Creates new String, doesn't modify original
        System.out.println("Inside method: " + str); // Hello World
    }
}