package com.company;

public class Student extends Person {
    int course = 3;

    public Student (int w, int h, int course) {
        super(w, h);
        this.course = course;
    }

    public void tell () {
        System.out.println("I'm a student and my weight is " + super.weight);
        System.out.println("my height is " + super.height);
    }
}
