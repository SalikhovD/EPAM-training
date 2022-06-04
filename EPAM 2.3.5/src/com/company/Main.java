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
        int elementNum;
        for (int i = 1; i < arr.length; i++) {
            elementNum = binarySearch(arr,0,i-1,arr[i]);
            insertElement(arr,elementNum,i);
        }

        //Проверяем отсортированный масив
        System.out.println();
        System.out.println("Массив после сортировки: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    //Функция вставки элемента в массив со сдвигом в большую сторону
    public static int [] insertElement (int arr [], int k, int i) {
        int buffer = arr[i];
        for (int j = i; j > k; j--) {
            arr[j] = arr[j-1];
        }
        arr[k] = buffer;
        return arr;
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
