package com.company;

public class Main {

    public static void main(String[] args) {
        //Создаем массивы и заполняем их
        int arr[] = new int[(int) (Math.random() * 19 + 1)];
        arr[0] = (int) (Math.random() * 30 - 15);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 - 50);
        }
        boolean done = false;
        int buffer;
        int swapCount = 0;

        //Проверяем сгенерированный масив
        System.out.println("Массив до сортировки: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        //Сортируем массив по возрастанию
        while (done == false) {
            done = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swapCount++;
                    buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    done = false;
                }
            }
        }

        //Проверяем отсортированный масив
        System.out.println();
        System.out.println("Массив после сортировки: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        System.out.println("Количество перестановок: " + swapCount);
    }
}
