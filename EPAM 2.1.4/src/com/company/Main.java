package com.company;

public class Main {

    public static void main(String[] args) {
        int N = (int) (Math.random()*999+1);
        double buffer = 0;
        int maxNum = 0;
        int minNum = 0;
        double [] a = new double [N];
        for (int i = 0; i < N; i++) {
            a [i] = ((Math.random()*20000)-10000);
        }
        for (int i = 0; i < N; i++) {
            if (a[i] > a[maxNum]) {
                maxNum = i;
            }
            if (a[i] < a[minNum]) {
                minNum = i;
            }
        }
        buffer = a[maxNum];
        a[maxNum] = a[minNum];
        a[minNum] = buffer;
    }
}
