package com.skh.animal;

import java.util.Scanner;

public class AnimalApp {
    public static void main(String[] args) {
        AnimalService animalService = new AnimalService();

        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your choice of animal dog, deer OR elephant");
        String inputValue = sc.next();

        if(inputValue.equals("dog")){
            Dog dog = new Dog();
            String soundsRef = animalService.sounds(dog);
            System.out.println(soundsRef);
        } else if (inputValue.equals("deer")) {
            Deer deer = new Deer();
            String soundsRef = animalService.sounds(deer);
            System.out.println(soundsRef);

        } else if (inputValue.equals("elep")) {
            Elephant elephant = new Elephant();
            String soundsRef = animalService.sounds(elephant);
            System.out.println(soundsRef);

        }else {
            System.out.println("Oops..!!!, you have given wrong input, Please try again!");
        }


    }
}
