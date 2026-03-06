package com.skh.interfaces;

public abstract interface MyInterface {
    public abstract void m1();
}
interface A{
    void m1();
}

interface   B{
    void m12();

}

class AA implements A, B{

    @Override
    public void m1() {

    }

    @Override
    public void m12() {

    }
}