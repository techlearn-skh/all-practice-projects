package com.skh.interfaces;

public interface Animal {
    public void eat();
    public void travel();
    void sounds();
}
class Dog implements Animal{

    @Override
    public void eat() {
        System.out.println("Eat in bowl....");
    }

    @Override
    public void travel() {
        System.out.println("Walk with four legs...");

    }

    @Override
    public void sounds() {
        System.out.println("Bow..Vow..");

    }
}

class Hen implements Animal{

    @Override
    public void eat() {
        System.out.println("Eat with beak....");
    }

    @Override
    public void travel() {
        System.out.println("Fly with wings...");

    }

    @Override
    public void sounds() {
        System.out.println("Kukrukooo...");

    }
}
