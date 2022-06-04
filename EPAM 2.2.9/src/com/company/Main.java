package com.company;

public class Main {
    public static int a; //Кол-во строк
    public static int b; //Кол-во столбцов

    public static void main(String[] args) {
        int maxSumm = 0;
        int columnSumm;
        int largestColumn = 0;

        //Создаем и заполняем матрицу
        a = (int)(Math.random()*19+3);
        b = (int)(Math.random()*19+3);
        int arr[][] = new int[a][b];
        System.out.println("Размерность матрицы: " + a + "x" + b);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = (int)(Math.random()*100);
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

        //Находим столбец с наибольшей суммой
        for (int i = 0; i < b; i++) {
            columnSumm = 0;
            for (int j = 0; j < a; j++) {
                columnSumm += arr[j][i];
            }
            if (columnSumm > maxSumm) {
                maxSumm = columnSumm;
                largestColumn = i;
            }
        }

        //Выводим результат
        System.out.println("");
        System.out.println("Столбец с максимальной суммой (первый, если таких несколько): " + largestColumn);
    }
}
