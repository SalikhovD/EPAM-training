package com.company;

public class Main {
    static int a; //Кол-во строк
    static int b; //Кол-во столбцов

    public static void main(String[] args) {
        int max;

        //Создаем и заполняем матрицу
        a = (int) (Math.random()*19 + 1);
        b = (int) (Math.random()*19 + 1);
        int arr[][] = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = (int)(Math.random()*200-100);
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

        //Ищем наибольший элемент
        max = arr[0][0];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("Максимальное значение элементов матрицы - " + max);

        // Заменяем нечетные элементы на max
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (Math.abs(arr[i][j]%2) == 1) {
                    arr[i][j] = max;
                }
            }
        }

        //Выводим результат
        System.out.print("Матрица после замены: ");
        for (int i = 0; i < a; i++) {
            System.out.println("");
            for (int j = 0; j < b; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
