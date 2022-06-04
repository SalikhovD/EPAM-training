package com.company;

public class Main {

    public static void main(String[] args) {
        //Создаем массивы и заполняем их
        int arr1 [] = new int[(int)(Math.random()*19+1)];
        arr1[0] = (int)(Math.random()*30-15);
        for (int i = 1; i < arr1.length; i++) {
            arr1[i] = (int)(Math.random()*100-50);
        }
        int max;
        int buffer;

        //Проверяем сгенерированный масив
        System.out.println("Массив до сортировки: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + ", ");
        }

        //Сортируем массив по убыванию
        for (int i = 0; i < arr1.length; i++) {
            max = i;
            for (int j = i; j < arr1.length; j++) {
                if (arr1[j] >= arr1[max]) {
                    max = j;
                }
            }
            buffer = arr1[i];
            arr1[i] = arr1[max];
            arr1[max] = buffer;
        }

        //Проверяем отсортированный масив
        System.out.println();
        System.out.println("Массив после сортировки: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + ", ");
        }
    }
}
