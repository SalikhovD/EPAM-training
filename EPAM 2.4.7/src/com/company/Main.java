package com.company;

public class Main {

    public static void main(String[] args) {
        //Сумма факториалов нечетных чисел от 1 до 9
        System.out.println("Сумма факториалов нечетных чисел от 1 до 9 равна " + oddFactorialSumm(1,9));
    }

    //Вычисление факториала
    public static long factorial (int n) {
        if (n == 0)
            return 1;
        long result = 1;
        for (int i = 1; i <= n ; i++) {
            result *= i;
        }
        return result;
    }
    //Сумма факториалов от m до k
    public static long oddFactorialSumm (int m, int k) {
        long result = 0;
        for (int i = m; i <= k; i += 2) {
            result += factorial(i);
        }
        return result;
    }
}
