package com.company;

public class Main {

    public static void main(String[] args) {
        String str = "Java is a high-level, class-based, object-oriented   programming language that is     designed to have as few implementation dependencies as possible. ";
        System.out.println("Изначальная строка: " + str);
        str = str.replace("a","ab");
        System.out.println("Строка после замены: " + str);
    }
}
