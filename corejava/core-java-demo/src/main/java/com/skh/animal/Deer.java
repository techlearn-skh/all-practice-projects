package com.skh.animal;

import java.util.List;

public class Deer implements IAnimal{
    @Override
    public String sound() {
        return "Buck,,Buck,,";
    }

    @Override
    public String running() {
        return "Avg. Speed 80 KMPH";
    }

    @Override
    public Integer sleepHours() {
        return 5;
    }

    @Override
    public List<String> eatingItems() {
        return List.of("Grass", "Fruits");
    }
}
