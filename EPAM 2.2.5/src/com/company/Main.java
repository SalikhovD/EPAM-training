package com.company;

public class Main {

    public static void main(String[] args) {
        // Создаем матрицу
        int n = (int)(Math.random()*99+1); //Кол-во строк и столбцов
        int arr[][] = new int[n][n];
        System.out.println("Размерность матрицы: " + n + "x" + n);

        // Заполняем матрицу
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                arr[i][j] = i+1;
            }
        }

        //Проверяем, что получилось
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }

        }

    }
}
