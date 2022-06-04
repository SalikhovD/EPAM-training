package com.company;

public class Main {

    public static void main(String[] args) {
        //Создаем массив чисел
        int num[] = new int[(int) (Math.random()*100)];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random()*1000-500);
        }

        //Проверяем сгенерированный массив
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + ", ");
        }

        //Ищем второе по величине число
        System.out.println("");
        System.out.println("Второе по величине число: " + num[preMax(num)]);
    }

    //Возвращает второе по величине число массива
    public static int preMax (int[] arr) {
        int max = 0;
        int preMax = 0;
        if (arr.length == 1)
            return 0;
        if (arr.length >= 2 && arr[0]>=arr[1]) {
            max = 0;
            preMax = 1;
        }
        else if (arr.length >= 2 && arr[0]<arr[1]) {
            max = 1;
            preMax = 0;
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                preMax = max;
                max = i;
            }
        }
        return preMax;
    }
}
