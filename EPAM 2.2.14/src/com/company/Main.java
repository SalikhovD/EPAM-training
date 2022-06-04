package com.company;

import java.util.Arrays;

public class Main {
    static int m; //Кол-во строк
    static int n; //Кол-во столбцов


    public static void main(String[] args) {
        int rand;

        //Создаем и заполняем матрицу
        n = (int) (Math.random()*9 + 1);
        m = (int) (Math.random()*2) + n;
        int arr[][] = new int[m][n];
        for (int j = 1; j < n; j++) {
            for (int a = 0; a < j;) {
                rand = (int)(Math.random()*m);
                if (arr[rand][j] == 0) {
                    arr[rand][j] = 1;
                    a++;
                }
            }
        }

        //Проверяем сгенерированную матрицу
        System.out.print("Сгенерированная матрица: ");
        for (int i = 0; i < m; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}

