package com.company;

public class Main {

    public static void main(String[] args) {
        // Создаем матрицу
        int n = ((int)(Math.random()*99+1))*2; //Кол-во строк и столбцов. n четное
        int arr[][] = new int[n][n];
        System.out.println("Размерность матрицы: " + n + "x" + n);
        // Заполняем нечетные строки
        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = j+1;
            }
        }
        // Заполняем четные строки
        for (int i = 1; i < n; i += 2) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = n-j;
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
