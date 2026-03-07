package com.skh;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        int[] inputArray = {4, 7, 2, 9, 1, 7, 1, 4, 7, 8};
        HashMap<Integer, Integer> elementFrequencyMap = new HashMap<Integer, Integer>();
        for (int i : inputArray) {
            elementFrequencyMap.put(i, elementFrequencyMap.getOrDefault(i, 0) + 1);
            if(elementFrequencyMap.containsKey(i)){
                elementFrequencyMap.put(i, elementFrequencyMap.get(i) + 1);
            }else {
                elementFrequencyMap.put(i,1);
            }
        }
        System.out.println(elementFrequencyMap);
    }
}








