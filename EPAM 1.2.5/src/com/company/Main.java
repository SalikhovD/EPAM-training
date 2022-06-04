package com.company;

public class Main {

    public static void main(String[] args) {
        double x = 5;
        double F;
        if (x <= 3) {
            F = Math.pow(x, 2) - 3 * x + 9;
        }
        else {
            F = 1 / (Math.pow(x, 3) + 6);
        }
        System.out.println(F);
    }
}
