package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Создаем 3 числа
        int num[] = new int[3];
        System.out.print("Сгенерированные числа: ");
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random()*100+1);
            System.out.print(num[i] + ", ");
        }

        //Проверяем, являются ли числа взаимнопростыми
        System.out.println();
        if (coprime(num))
            System.out.print("Числа массива взаимно простые");
        else
            System.out.print("Числа массива не взаимно простые");
    }

    //Функция нахождения НОД
    public static int gcd (int num []) {
        int primes[] = decompositionIntoPrimeNumbers(num[0]);
        for (int i = 1; i < num.length; i++) {
            primes = mergePrimeNumbers(primes,decompositionIntoPrimeNumbers(num[i]));
        }
        int gcd = 1;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i] != 0) {
                gcd *= Math.pow(i,primes[i]);
                primes[i] = 0;
            }
        }
        return gcd;
    }
    //Функция для нахождения общих множителей в двух рядах
    public static int[] mergePrimeNumbers (int arr1[],int arr2[]) {
        int arr[];
        arr = new int [Math.min(arr1.length, arr2.length)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.min(arr1[i],arr2[i]);
        }
        return arr;
    }
    //Функция разложения числа на множители
    public static int[] decompositionIntoPrimeNumbers (long num) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (num == 0) {
            list.add(0);
        }
        if (num == 1) {
            list.add(1);
        }
        int i = 2;
        while (i<=num) {
            if (num%i == 0) {
                num /= i;
                list.add(i);
            }
            else {
                i++;
            }
        }
        int arr[] = new int[list.get(list.size()-1)+1];
        for (int j = 0; j < list.size(); j++) {
            arr[list.get(j)]++;
        }
        return arr;
    }
    //Проверка, являются ли числа массива взаимно простые
    public static boolean coprime (int [] arr) {
        if (gcd(arr) == 1)
            return true;
        else
            return false;
    }
}
