package com.company;

public class Main {

    public static void main(String[] args) {
        int N = ((int) (Math.random()*499+1))*2;
        double [] a = new double [N];
        for (int i = 0; i < N; i++) {
            a [i] = ((Math.random()*20000)-10000);
        }
            double max = a[0] + a[N-1];
        for (int i = 1; i <= N/2; i++) {
            if (a[i]+a[N-1-i] > max) {
                max = a[i]+a[N-1-i];
                System.out.println("max новое значение: " + max + "при i = " + i);
            }
        }
        System.out.println("Количество элементов в исходном массиве: " + N);
        System.out.println("max: " + max);

    }
}
