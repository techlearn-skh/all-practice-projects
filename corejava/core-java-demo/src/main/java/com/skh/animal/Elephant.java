package com.skh.animal;

import java.util.List;

public class Elephant implements  IAnimal{

    @Override
    public String sound() {
        return "elephant Roaring..";
    }

    @Override
    public String running() {
        return "Avg. Speed 30 KMPH";
    }

    @Override
    public Integer sleepHours() {
        return 10;
    }

    @Override
    public List<String> eatingItems() {
        return List.of("Sugarcane", "fruits", "leaves");
    }
}
