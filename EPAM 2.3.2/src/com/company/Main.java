package com.company;

public class Main {

    public static void main(String[] args) {
        //Создаем массивы и заполняем их
        int arr1 [] = new int[(int)(Math.random()*9+1)];
        int arr2 [] = new int[(int)(Math.random()*9+1)+ arr1.length];
        arr1[0] = (int)(Math.random()*30-15);
        for (int i = 1; i < arr1.length; i++) {
            arr1[i] = arr1[i-1] + (int)(Math.random()*10);
        }
        arr2[0] = (int)(Math.random()*30-15);
        for (int i = 1; i < arr2.length- arr1.length; i++) {
            arr2[i] = arr2[i-1] + (int)(Math.random()*10);
        }

        //Проверяем сгенерированные масивы
        System.out.println("Массив 1: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + ", ");
        }
        System.out.println();
        System.out.println("Массив 2: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + ", ");
        }

        //Объединяем массивы
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (j < arr1.length) {
                if (arr1[j] <= arr2[i]) {
                    arr2 = moveForvard(i, arr2);
                    arr2[i] = arr1[j];
                    j++;
                }
            }
            if (i >= arr2.length- arr1.length+j) {
                arr2[i] = arr1[j];
                j++;
            }
        }

        //Проверяем объединенный массив
        System.out.println();
        System.out.println("Массив 2: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + ", ");
        }
    }

    public static int [] moveForvard (int k, int arr []) {
        for (int i = arr.length-1; i > k; i--) {
            arr[i] = arr[i-1];
        }
        arr[k] = 0;
        return arr;
    }
}
