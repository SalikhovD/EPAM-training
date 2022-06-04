package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Создаем и наполняем массив
        int n = (int) (Math.random()*99999+1) ;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random()*10000-5000);
        }
        System.out.println("Элементов в массиве: " + n);

        Arrays.sort(arr);
        int num = 0;
        int rep = 1;
        int maxRep = 1;
        for (int i = n-1; i > 0; i--) {
            if (arr[i] == arr[i-1]) {
                rep += 1;
                System.out.println("найдено повторение");
            }
            else {
                if (rep >= maxRep) {
                    maxRep = rep;
                    rep = 1;
                    num = arr[i];
                }
                else {
                    rep = 1;
                }
            }
        }
        if (rep >= maxRep) {
            maxRep = rep;
            num = arr[0];
        }
        System.out.println("Максимальное количество повторений: " + maxRep + " числа " + num);
    }
}
