package com.company;

public class Main {

    public static void main(String[] args) {
        double a, b, c;
        a = 5;
        b = 10;
        c = 15;
        double result = (b + Math.sqrt(Math.pow(b,2)+4*a*c))/(2*a)-Math.pow(a,3)*c+Math.pow(b,-2);
        System.out.println(result);
    }
}
