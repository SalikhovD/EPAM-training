package com.company;

public class Main {

    public static void main(String[] args) {
        String str = "информатика";
        String cake = str.copyValueOf(str.toCharArray(),7,1);
        cake = cake.concat(str.copyValueOf(str.toCharArray(),3,1));
        cake = cake.concat(str.copyValueOf(str.toCharArray(),4,1));
        cake = cake.concat(str.copyValueOf(str.toCharArray(),7,1));
        System.out.println(cake);
    }
}
