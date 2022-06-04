package com.company;

public class Main {

    public static void main(String[] args) {
        // Создаем и заполняем матрицу
        int a = (int)(Math.random()*99+1);
        double arr[][] = new double[a][a];
        System.out.println("Размерность матрицы: " + a + "x" + a);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                arr[i][j] = Math.random()*10000-5000;
            }
        }

        // Выводим элементы на диагонали
        for (int i = 0; i < a; i++) {
            System.out.println(arr[i][i]);
        }
    }
}
