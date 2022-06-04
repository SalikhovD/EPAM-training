package com.company;

import java.util.Arrays;

public class Main {
    static int a; //Кол-во строк
    static int b; //Кол-во столбцов

    public static void main(String[] args) {

        //Создаем и заполняем матрицу
        a = (int)(Math.random()*9+1);
        b = (int)(Math.random()*9+1);
        int arr[][] = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = (int)(Math.random()*100-50);
            }
        }

        //Создаем вспомогательную матрицу
        int buffer[] = new int[a];

        //Проверяем сгенерированную матрицу
        System.out.print("Сгенерированная матрица: ");
        for (int i = 0; i < a; i++) {
            System.out.println("");
            for (int j = 0; j < b; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }

        //Сортируем столбцы по возрастанию
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                buffer[j] = arr[j][i];
            }
            Arrays.sort(buffer);
            for (int j = 0; j < a; j++) {
                arr[j][i] = buffer[j];
            }
        }

        //Выводим отсортированную матрицу
        System.out.println("");
        System.out.print("Отсортированная матрица по возрастанию: ");
        for (int i = 0; i < a; i++) {
            System.out.println("");
            for (int j = 0; j < b; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }

        //Сортируем столбцы по убыванию
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                buffer[j] = arr[j][i];
            }
            Arrays.sort(buffer);
            for (int j = 0; j < a; j++) {
                arr[j][i] = buffer[a-j-1];
            }
        }

        //Выводим отсортированную матрицу
        System.out.println("");
        System.out.print("Отсортированная матрица по убыванию: ");
        for (int i = 0; i < a; i++) {
            System.out.println("");
            for (int j = 0; j < b; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
