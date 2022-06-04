package com.company;

public class Main {

    public static void main(String[] args) {
        double n = 25;
        System.out.println(n);
        if (n<0)
            return false;
        double devided = Math.sqrt(n);
        if (devided%1 == 0)
            return true;
        else
            return false;

    }
}
