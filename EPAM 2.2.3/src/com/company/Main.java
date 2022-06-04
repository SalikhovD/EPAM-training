package com.company;

public class Main {

    public static void main(String[] args) {
        // Создаем и заполняем матрицу
        int a = (int)(Math.random()*99+1); //Кол-во строк
        int b = (int)(Math.random()*99+1); //Кол-во столбцов
        int arr[][] = new int[a][b];
        System.out.println("Размерность матрицы: " + a + "x" + b);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = (int) (Math.random()*10000-5000);
            }
        }

        // Определяем номер столбца и строки и выводим в консоль
        int k = (int) (Math.random()*a-1); //Строка
        int p = (int) (Math.random()*b-1); //Столбец

        //Выводим строку
        System.out.println("Строка номер " + k + ":");
        for (int i = 0; i < b-1; i++) {
            System.out.print(arr[k][i] + ", ");
        }
            System.out.println(arr[k][p]);

        //Выводим столбец
        System.out.println("Столбец номер " + p + ":");
        for (int i = 0; i < a; i++) {
            System.out.println(arr[i][p]);
        }
    }
}
