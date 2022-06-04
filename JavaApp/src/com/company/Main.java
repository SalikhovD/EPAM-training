package com.company;
import java.lang.String;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Person dima = new Person(55,168);
        dima.say("vanya");
        Student maxim = new Student(47,150,2);
        maxim.say("dima");
        maxim.tell();


    }
}
