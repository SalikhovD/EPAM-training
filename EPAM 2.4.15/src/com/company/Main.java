package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            int[] sequences = numbersSequences(i);
            System.out.println("Последовательность " + i + "-разрядных чисел");
            for (int j = 0; j < sequences.length; j++) {
                System.out.println(sequences[j]);
            }
        }
    }

    //Возвращает массив n-разрядных чисел, цифры которых образуют возрастающую последовательность
    public static int[] numbersSequences (int n) {
        int[] sequences = new int[10-n];
        for (int i = 0; i < sequences.length; i++) {
            for (int j = i+1; j <= i+n; j++) {
                sequences[i] = sequences[i]*10+j;
            }
        }
        return sequences;
    }
}
