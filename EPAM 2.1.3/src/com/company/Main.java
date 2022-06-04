package com.company;

public class Main {

    public static void main(String[] args) {
        int N = (int) (Math.random()*999+1);
        int neg = 0;
        int pos = 0;
        int zero = 0;
        double [] a = new double [N];
        for (int i = 0; i < N; i++) {
            a [i] = ((Math.random()*20000)-10000);
        }
        for (int i = 0; i < N; i++) {
            if (a[i] == 0)
                zero++;
             else if (a[i] > 0)
                pos++;
            else
                neg++;
        }
        System.out.println("Количество элементов: " + N);
        System.out.println("Положительных элементов: " + pos);
        System.out.println("Отрицательных элементов: " + neg);
        System.out.println("Нулевых элементов: " + zero);
    }
}
