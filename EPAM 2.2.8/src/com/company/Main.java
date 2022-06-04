package com.company;

import java.util.Scanner;

public class Main {
    public static int a; //Кол-во строк
    public static int b; //Кол-во столбцов
    public static int c1; //Первый столбец для перестановки
    public static int c2; //Второй столбец для перестановки

    public static void main(String[] args) {
        //Создаем и заполняем матрицу
        a = (int)(Math.random()*9+3);
        b = (int)(Math.random()*9+3);
        int buffer;
        int arr[][] = new int[a][b];
        System.out.println("Размерность матрицы: " + a + "x" + b);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = (int)(Math.random()*100-50);
            }
        }

        //Проверяем сгенерированную матрицу
        System.out.print("Сгенерированная матрица: ");
        for (int i = 0; i < a; i++) {
            System.out.println("");
            for (int j = 0; j < b; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }

        //Вводим строки с клавиатуры
        DataEntry();

        //Меняем строки местами
        for (int i = 0; i < a; i++) {
            buffer = arr[i][c1];
            arr[i][c1] = arr[i][c2];
            arr[i][c2] = buffer;
        }

        //Проверяем, что получилось
        System.out.print("Матрица после перестановки: ");
        for (int i = 0; i < a; i++) {
            System.out.println("");
            for (int j = 0; j < b; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    public static void DataEntry() {
        //Вводим строки с клавиатуры
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("Введите номер первого стобца");
        c1 = in.nextInt() - 1;
        System.out.println("Введите номер второго столбца");
        c2 = in.nextInt() - 1;
        if (c1 >a-1 || c2 >b-1) {
            System.out.print("Введенные номера больше размера матрицы (" + a + " строк). введите значения заново");
            DataEntry();
        }
    }
}
