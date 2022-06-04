package com.company;

public class Main {

    public static void main(String[] args) {
        //Создаем и заполняем массив
        int arr [] = new int[(int)(Math.random()*98+2)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100-50);
        }

        //Проверяем сгенерированный масив
        System.out.println("Массив до сортировки: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        //Сортируем массив по возрастанию
        int buffer;
        for (int i = 0; i < arr.length-1;) {
            if (arr[i] > arr[i+1]) {
                buffer = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = buffer;
                if (i > 0) {
                    i--;
                }
            }
            else i++;
        }

        //Проверяем отсортированный масив
        System.out.println();
        System.out.println("Массив после сортировки: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
