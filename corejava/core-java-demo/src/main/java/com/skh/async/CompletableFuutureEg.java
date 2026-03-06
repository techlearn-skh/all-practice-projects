package com.skh.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuutureEg {
    static CompletableFuture<String> method1() {
        System.out.println("Started Method - 1");
        sleep(3000);
        return CompletableFuture.completedFuture("Result from Method 1");
    }

    static CompletableFuture<String> method2() {
        System.out.println("Started Method - 2");
        sleep(3000);
        return CompletableFuture.completedFuture("Result from Method 2");
    }

    static CompletableFuture<String> method3() {
        System.out.println("Started Method - 3");
        sleep(3000);
        return CompletableFuture.completedFuture("Result from Method 3");
    }


    static String normalMethod1() {
        System.out.println("Started Method - 1");
        sleep(3000);
        return "Result from normalMethod1 1";
    }

    static String normalMethod2() {
        System.out.println("Started Method - 2");
        sleep(3000);
        return "Result from normalMethod2 2";
    }

    static String normalMethod3() {
        System.out.println("Started Method - 3");
        sleep(3000);
        return "Result from normalMethod3 3";
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Normal methods calling:
//        System.out.println(normalMethod1());
//        System.out.println(normalMethod2());
//        System.out.println(normalMethod3());

        // Async methods calling:
        CompletableFuture<String> c1 = method1();
        CompletableFuture<String> c2 = method2();
        CompletableFuture<String> c3 = method3();

        CompletableFuture.allOf(c1,c2,c3).join();
        System.out.println(c1.get());
        System.out.println(c2.get());
        System.out.println(c3.get());



    }


}

















