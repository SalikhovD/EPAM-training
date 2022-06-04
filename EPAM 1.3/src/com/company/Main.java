package com.company;

public class Main {

    public static void main(String[] args) {
        double x, y;
        x = 5;
        y = 10;
        double result = (Math.sin(x)+Math.cos(y))/(Math.cos(x)-Math.sin(y))*Math.tan(x*y);
        System.out.println(result);

    }
}
