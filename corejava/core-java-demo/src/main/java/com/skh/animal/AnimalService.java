package com.skh.animal;

import java.util.List;

public class AnimalService {

    public String sounds(IAnimal animal) {
        return animal.sound();
    }

    public String running(IAnimal animal) {
        return animal.running();
    }


    public Integer sleepHours(IAnimal animal) {
        return animal.sleepHours();
    }

    public List<String> eatingItems(IAnimal animal) {
        return animal.eatingItems();
    }


}
