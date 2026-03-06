package com.skh.callbyValueRef;

public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        System.out.print("Before modifyArray: ");
        printArray(numbers); // [1, 2, 3]

        modifyArray(numbers);
        System.out.print("After modifyArray: ");
        printArray(numbers); // [10, 2, 3] (changed!)

        reassignArray(numbers);
        System.out.print("After reassignArray: ");
        printArray(numbers); // [10, 2, 3] (unchanged!)
    }

    static void modifyArray(int[] arr) {
        arr[0] = 10;  // Changes the actual array
    }

    static void reassignArray(int[] arr) {
        arr = new int[]{100, 200, 300};  // Only changes local reference
        System.out.print("Inside reassignArray: ");
        printArray(arr); // [100, 200, 300]
    }

    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}