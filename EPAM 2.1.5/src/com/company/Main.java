package com.company;

public class Main {

    public static void main(String[] args) {
        int [] a = new int [(int) (Math.random()*999+1)];
        for (int i = 0; i < a.length; i++) {
            a [i] = (int) (Math.random()*2000-1000);
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] > i) {
                System.out.println("a(" + i + ") равен " + a[i]);
            }

        }
        System.out.println("Количество элементов в исходном массиве:" + a.length);
    }
}
