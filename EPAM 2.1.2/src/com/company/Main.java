package com.company;

public class Main {

    public static void main(String[] args) {
        int N = (int) (Math.random()*999+1);
        double Z = ((Math.random()*1000));
        int result = 0;
        double [] a = new double [N];
        for (int i = 0; i < N; i++) {
            a [i] = (Math.random()*1000);
        }
        for (int i = 0; i < N; i++) {
            if (a[i] > Z) {
                a[i] = Z;
                result++;
            }
        }
        System.out.println("Количество элементов: " + N);
        System.out.println("Z равен: " + Z);
        System.out.println("Количество замен: " + result);
    }
}
