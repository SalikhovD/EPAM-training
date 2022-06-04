package com.company;

public class Main {

    public static void main(String[] args) {
        double R = 123.456;
        double result = Math.round((R - R%1) + R%1*1000000);
        result /=1000;
        System.out.println(result);
    }
}
