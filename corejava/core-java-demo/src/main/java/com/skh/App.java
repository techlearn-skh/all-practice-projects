package com.skh;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) {

//Creating an empty HashMap with default initial capacity and default load factor

        HashMap<String, Integer> studentNameMarksMap = new HashMap<String, Integer>();

        //Inserting entries into studentNameMarksMap

        studentNameMarksMap.put("Aditya Sen", 57);
        studentNameMarksMap.put("Harris Brar", 34);
        studentNameMarksMap.put("Sarah Amin", 61);
        studentNameMarksMap.put("Rishika Gowda", 75);
        studentNameMarksMap.put("Rohit Gupta", 68);
        studentNameMarksMap.put("Andriel Hope", 31);
        studentNameMarksMap.put("Deepti Sharma", 81);
        studentNameMarksMap.put("Irfan Ali", 33);
        studentNameMarksMap.put("Ruth Prabhu", 66);
        studentNameMarksMap.put("Arun Trivedi", 29);

        studentNameMarksMap.clear();
        System.out.println(studentNameMarksMap);


        System.out.println(LocalDate.of(1978,12,13));


    }
}








