package com.company;

public class Main {

    public static void main(String[] args) {
	    // Создаем и заполняем матрицу
        int a = (int)(Math.random()*99+1);
        int b = (int)(Math.random()*99+1);
        double arr[][] = new double[a][b];
        System.out.println("Размерность матрицы: " + a + "x" + b);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = Math.random()*10000-5000;
            }
        }

        // Сравниваем первый и последний элемент и выводим столбец в консоль
        for (int i = 1; i < a; i += 2) {
            if (arr[i][0] > arr[i][b-1]) {
                System.out.println("Столбец номер " + i);
                for (int j = 0; j < b; j++) {
                    System.out.println(arr[i][j]);
                }
            }
        }

    }
}
