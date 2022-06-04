package com.company;

public class Main {
    public static int a; //Кол-во строк и столбцов

    public static void main(String[] args) {

        //Создаем и заполняем матрицу
        a = (int)(Math.random()*19+3);
        int arr[][] = new int[a][a];
        System.out.println("Размерность матрицы: " + a + "x" + a);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                arr[i][j] = (int)(Math.random()*200-50);
            }
        }

        //Проверяем сгенерированную матрицу
        System.out.print("Сгенерированная матрица: ");
        for (int i = 0; i < a; i++) {
            System.out.println("");
            for (int j = 0; j < a; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }

        //Выводим положительные элементы главной диагонали
        System.out.println("");
        System.out.print("Положительные элементы главной диагонали: ");
        for (int i = 0; i < a; i++) {
            if (arr[i][i] > 0) {
                System.out.print(arr[i][i] + ", ");
            }
        }
    }
}
