package com.skh;



interface InterfaceOne
{
    default void anyMethod()
    {
        System.out.println("Hi... From Interface One");
    }
}

interface InterfaceTwo extends InterfaceOne
{
    @Override
    default void anyMethod()
    {
        System.out.println("Hi... From Interface Two");
    }
}

public class Test  implements InterfaceTwo, InterfaceOne{



    public static void main(String[] args) {
        new Test().anyMethod();
    }

}
interface MyInterface {

    void m1();
    default void m2() {
        System.out.println("MyInterface");
    }
}

interface MyInterface2 {
    void m1();
    default void m2() {
        System.out.println("MyInterface2");
    }
}
class C1 implements MyInterface {
    @Override
    public void m1() {
        System.out.println("This is C1 class");
    }
    @Override
    public void m2() {
        System.out.println("Welcome to Infosys...!!!!");// 100 lines lgic
    }
}

class C2 implements MyInterface {
    @Override
    public void m1() {
        System.out.println("This is C2 class");
    }
    @Override
    public void m2() {
        System.out.println("Hiiiiiiiiii.!!!!");// 200 lines...
    }


}

























