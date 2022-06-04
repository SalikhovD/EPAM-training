package com.company;

public class Main {

    public static void main(String[] args) {
        int N = (int) (Math.random()*999+1);
        double [] a = new double [N];
        for (int i = 0; i < N; i++) {
            a [i] = ((Math.random()*20000)-10000);
        }
        double result = 0;
        boolean prime = true;
        if (N >= 2) {
            for (int i = 2; i < N; i++) {
                for (int j = 2; j < i; j++) {
                    if (i%j == 0) {
                        prime = false;
                    }
                }
                if (prime) {
                    result += a[i];
                }
                prime = true;

            }
        }
        System.out.println(result);

    }
}
