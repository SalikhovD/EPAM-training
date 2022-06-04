package com.company;

public class Main {

    public static void main(String[] args) {
        // Создаем матрицу
        int N = (int)(Math.random()*9+1); //Кол-во строк и столбцов
        double arr[][] = new double[N][N];
        System.out.println("Размерность матрицы: " + N + "x" + N);

        // Заполняем
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = Math.sin((Math.pow(i,2)-Math.pow(j,2))/N);
            }
        }

        //Проверяем, что получилось
        for (int i = 0; i < N; i++) {
            System.out.println("");
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
