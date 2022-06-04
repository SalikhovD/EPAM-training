package com.company;

public class Main {
    static int a = 10; //Кол-во строк
    static int b = 20; //Кол-во столбцов
    static int fivesCount = 0;

    public static void main(String[] args) {

        //Создаем и заполняем матрицу
        int arr[][] = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = (int)(Math.random()*16);
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

        //Выводим положительные элементы главной диагонали
        System.out.println("");
        System.out.print("Строки с числом 5, встречающимся 3 и более раз: ");
        for (int i = 0; i < a; i++) {
            fivesCount = 0;
            for (int j = 0; j < b; j++) {
                if (arr[i][j] == 5) {
                    fivesCount += 1;
                }
            }
            if (fivesCount >= 3) {
                System.out.print(i + ", ");
            }
        }
    }
}
