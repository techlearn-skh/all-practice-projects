package com.skh.callbyValueRef;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

public class ObjectExample {
    public static void main(String[] args) {
        Person person = new Person("Alice");
        System.out.println("Before modify: " + person.name); // Alice

        modifyObject(person);
        System.out.println("After modifyObject: " + person.name); // Bob

        reassignObject(person);
        System.out.println("After reassignObject: " + person.name); // Bob (not Charlie!)
    }

    // This modifies the object the reference points to
    static void modifyObject(Person p) {
        p.name = "Bob";  // Changes the actual object's state
    }
    // This tries to reassign the reference (won't affect original)
    static void reassignObject(Person p) {
        p = new Person("Charlie");  // Only changes local copy of reference
        System.out.println("Inside reassignObject: " + p.name); // Charlie
    }
}