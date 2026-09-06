package com.skh;


import com.skh.interfaces.AnimalInterface;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws UnknownHostException {
        // Get all environment variables
        Map<String, String> envMap = System.getenv();
        envMap.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });

        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("localhost : "+localhost);


    }
}

