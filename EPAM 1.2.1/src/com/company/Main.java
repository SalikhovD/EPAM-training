package com.company;

public class Main {

    public static void main(String[] args) {
    double angA = 30;
	double angB = 60;
    if (angA <= 0 || angB <=0 || angA+angB >= 180)
        System.out.println("Такого треугольника не существует.");
    else if (angA+angB == 90)
            System.out.println("Это прямоугольный треугольник");
    else
        System.out.println("Это не прямоугольный треугольник");
    }
}
