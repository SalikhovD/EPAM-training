package com.company;

public class Main {

    public static void main(String[] args) {
        int N = (int) (Math.random()*999+1);
        int K = (int) ((Math.random()*99) + 1);
        int result = 0;
        int [] A = new int [N];
        for (int i = 0; i < N; i++) {
            A [i] = (int) (Math.random()*1000);
        }
        for (int i = 0; i < N; i++) {
            if (A[i]%K == 0) {
                result += A[i];
            }
        }
        System.out.println("Количество элементов: " + N);
        System.out.println("К равен: " + K);
        System.out.println("Сумма кратных К элементов: " + result);
    }
}
