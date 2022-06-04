package com.company;

public class Main {

    public static void main(String[] args) {

        //Создаем массивы и заполняем их
        int arr2 [] = new int[(int)(Math.random()*9+1)];
        int arr1 [] = new int[(int)(Math.random()*9+1+ arr2.length)];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random()*100-50);
        }
        for (int i = 0; i < arr1.length- arr2.length; i++) {
            arr1[i] = (int) (Math.random()*100-50);
        }
        int k = (int) (Math.random()*(arr1.length-arr2.length));

        //Проверяем сгенерированный массив и число k
        System.out.println("Массив 1: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + ", ");
        }
        System.out.println();
        System.out.println("Массив 2: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + ", ");
        }
        System.out.println();
        System.out.print("Число k - " + k);

        //Раздвигаем первый массив и вставляем второй в образовавшееся пространство
        for (int i = arr1.length-arr2.length-1; i > k; i--) {
            arr1[i+ arr2.length] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr1[i+k+1] = arr2[i];
        }

        //Проверяем объединенный массив
        System.out.println();
        System.out.println("Массив 1 после объединения: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + ", ");
        }
    }
}
