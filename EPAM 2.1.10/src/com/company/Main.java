package com.company;

public class Main {

    public static void main(String[] args) {
        // Создаем и заполняем массив
        int n = (int) (Math.random()*999+1);
        System.out.println("Количество элементов в массиве: " + n);
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random()*10000-5000);
        }

        //Обнуляем каждый второй элемент
        for (int i = 1; i < n; i += 2) {
            arr[i] = 0;
        }
    }
}
