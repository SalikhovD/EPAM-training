package com.company;

public class Main {

    public static void main(String[] args) {
        // Создаем матрицу
        int n = ((int)(Math.random()*24+1))*2; //Кол-во строк и столбцов. n четное
        int arr[][] = new int[n][n];
        System.out.println("Размерность матрицы: " + n + "x" + n);

        // Заполняем верхнюю половину матрицы
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-i; j++) {
                arr[i][j] = 1;
            }
        }
        // Заполняем нижнюю половину матрицы
        for (int i = n/2; i < n; i++) {
            for (int j = n-i-1; j < i+1; j++) {
                arr[i][j] = 1;
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
