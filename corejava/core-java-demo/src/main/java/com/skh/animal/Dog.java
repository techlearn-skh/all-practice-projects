package com.skh.animal;

import java.util.List;

public class Dog implements IAnimal {

    @Override
    public String sound() {
        return "Bow..Bow!!!!";
    }

    @Override
    public String running() {
        return "Avg. Speed 30KM";
    }

    @Override
    public Integer sleepHours() {
        return 7;
    }

    @Override
    public List<String> eatingItems() {
        return List.of("non-veg", "milk", "biscuits");

        //AZAD
    }
}
