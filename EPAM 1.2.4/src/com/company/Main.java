package com.company;

public class Main {

    public static void main(String[] args) {
        double A = 15;
        double B = 40;
        double x = 25;
        double y = 50;
        double z = 15;
        boolean fit = false;

        if (x <= A) {
            if (y <= B || z <= B)
                fit = true;
        }
        if (y <= A)
            if (z <= B || x <= B)
                fit = true;
        if (z <= A)
            if (x <= B || y <= B)
                fit = true;
            if (fit)
                System.out.println("Кирпич проходит в отверстие");
            else
                System.out.println("Кирпич НЕ проходит в отверстие");
    }
}
