package com.company;

public class Person {
    public int height = 180;
    public int weight = 75;
    public void say (String name) {
        System.out.println("Hello " + name);
        System.out.println("My height is " + height);
    }
    public Person (int h) {
        height = h;
    }
    public Person (int w, int h) {
        weight = w;
        height = h;
    }
    public Person () {}
}
