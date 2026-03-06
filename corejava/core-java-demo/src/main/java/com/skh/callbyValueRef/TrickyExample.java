package com.skh.callbyValueRef;

public class TrickyExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        modify(sb);
        System.out.println(sb); // What will this print?
    }

    static void modify(StringBuilder s) {
        s.append(" World");     // Line 1
        s = new StringBuilder("New"); // Line 2
        s.append(" Text");      // Line 3
    }
}