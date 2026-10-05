package com.skh;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

public class App {
    public static void main(String[] args) throws UnknownHostException {
        // Get all environment variables
        Map<String, String> envMap = System.getenv();
        envMap.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });

        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("localhost : "+localhost);


        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
