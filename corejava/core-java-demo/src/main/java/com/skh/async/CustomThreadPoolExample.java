package com.skh.async;

import java.util.concurrent.*;
public class CustomThreadPoolExample {
    private static final ExecutorService customExecutor = Executors.newFixedThreadPool(5);
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Running in custom thread pool: " + Thread.currentThread().getName());
        }, customExecutor);
        future.join();
        customExecutor.shutdown();
    }
}