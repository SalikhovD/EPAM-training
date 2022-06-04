package com.company;

public class Main {

    public static void main(String[] args) {
        double x = -1.5;
        double y = 2.5;
        if (x < -4 || x > 4) {
            System.out.println(false);
        } else if (y < -3 || y > 4) {
            System.out.println(false);
        } else if (y <= 0) {
            System.out.println(true);
        } else if (x < -2 || x > 2) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }
}
