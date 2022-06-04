package com.company;

public class Main {

    public static void main(String[] args) {
        //Создаем и заполняем массивы
        int arr1 [] = new int[(int)(Math.random()*98+2)];
        arr1[0] = (int)(Math.random()*100-100);
        for (int i = 1; i < arr1.length; i++) {
            arr1[i] = (int)(Math.random()*10)+arr1[i-1];
        }
        int arr2 [] = new int[(int)(Math.random()*98+2)];
        arr2[0] = (int)(Math.random()*100-100);
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = (int)(Math.random()*10)+arr2[i-1];
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

        //Находим для каждого элемента массива 2 места для вставки в массив 1
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("Элемент массива 2 " + i + ", равный " + arr2[i] + " необходимо поместить на место элемента " + binarySearch(arr1,0,arr1.length-1,arr2[i]) + " массива 1");
        }
    }

    //Двоичный поиск места для вставки элемента в миссив
    public static int binarySearch(int [] arr, int first, int last, int num) {
        int pos;
        while (last != first) {
            pos = ((last-first)/2)+first;
            if (num > arr[pos]) {
                first = pos+1;
            }
            else if (num < arr[pos]){
                last = pos;
            }
            else {
                last = pos;
                first = pos;
            }
        }
        if (num >= arr[last]) {
            return last+1;
        }
        else {
            return last;
        }
    }
}
