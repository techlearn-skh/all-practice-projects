package com.skh;


import com.skh.interfaces.AnimalInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        String P_CONST = "PARAM:";
        Map<String, String> map = new HashMap<>();

        map.put("", "empty");
        map.put("", "empty");
        map.put("PARAM:A", "true");
        map.put("", "empty");
       // System.out.println(map);

        boolean b = map.entrySet().stream().anyMatch(e ->
                e.getKey() != null &&
                        !e.getKey().trim().isEmpty());

        System.out.println(b);

       /* Map<String, String> collect = map.entrySet().stream()
                .filter(m -> m.getKey().startsWith(P_CONST) && m.getKey().substring(P_CONST.length()).length() >= 1)
                .collect(Collectors.toMap(mm -> mm.getKey().substring(P_CONST.length()), Map.Entry::getValue));

        map.entrySet().removeIf(entry -> entry.getKey() != null && entry.getKey().trim().isEmpty());*/

      /*  Stream.of(map).map(m -> new Test().removeEmptyKeyMapObjects(m))
                        .forEach(System.out::println);*/



    }
}

