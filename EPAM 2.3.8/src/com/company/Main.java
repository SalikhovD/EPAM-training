package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Создаем и заполняем массив с дробями
        long fractions [][] = new long [(int) (Math.random()*10+1)][2];
        for (int i = 0; i < fractions.length; i++) {
            fractions [i][0] = (int) (Math.random()*100-50);
            fractions [i][1] = (int) (Math.random()*100+1);
        }

        //Проверяем сгенерированные дроби и их сумму
        Check(fractions, "Ряд сгенерированных дробей: ");

        //Сокращаем дроби
        fractions = reduction(fractions);

        //Проверяем сокращенные дроби и их сумму
        Check(fractions, "Ряд сокращенных дробей: ");

        //Вычисляем НОК
        int primes[] = new int[1];
        for (int i = 0; i < fractions.length; i++) {
            primes = mergePrimeNumbers(primes,decompositionIntoPrimeNumbers(fractions[i][1]));
        }
        System.out.print("Матрица простых чисел НОК: ");
        for (int i = 0; i < primes.length; i++) {
            System.out.print(primes[i] + ", ");
        }
        long lcm = 1;
        for (int i = 0; i < primes.length;) {
            if (primes[i] != 0) {
                lcm *= i;
                primes[i]--;
            }
            else i++;
        }
        System.out.println();
        System.out.print("НОК: " + lcm);

        //Приводим все дроби к одному знаменателю
        for (int i = 0; i < fractions.length; i++) {
            fractions[i][0] *= (lcm/fractions[i][1]);
            fractions[i][1] = lcm;
        }

        //Проверяем приведенные дроби и их сумму
        Check(fractions, "Ряд приведенных дробей: ");

        //Сортируем по возрастанию сортировкой Шелла
        fractions = shellSort(fractions);

        //Проверяем отсортированные дроби и их сумму
        Check(fractions, "Ряд отсортированных дробей: ");

        //Сокращаем дроби
        fractions = reduction(fractions);

        //Проверяем сокращенные дроби и их сумму
        Check(fractions, "Ряд отсортированных и сокращенных дробей: ");
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
    //Функция для слияния двух рядов простых чисел
    public static int[] mergePrimeNumbers (int arr1[],int arr2[]) {
        int arr[];
            arr = new int [Math.max(arr1.length, arr2.length)];
            for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
                arr[i] = Math.max(arr1[i],arr2[i]);
            }
        if (arr1.length >= arr2.length) {
            for (int i = arr2.length; i < arr1.length; i++) {
                arr[i] = arr1[i];
            }
        }
        else {
            for (int i = arr1.length; i < arr2.length; i++) {
                arr[i] = arr2[i];
            }
        }
        return arr;
    }
    //Функция для сокращения дроби
    public static long[][] fractionReduction (long arr1[][]) {
        boolean minus = false;
        if (arr1[0][0] < 0) {
            minus = true;
            arr1[0][0] *= -1;
        }
        long reduced[][] = new long[1][2];
        reduced[0][0] = arr1[0][0];
        reduced[0][1] = arr1[0][1];
        int prime1[] = decompositionIntoPrimeNumbers(arr1[0][0]);
        int prime2[] = decompositionIntoPrimeNumbers(arr1[0][1]);
        int minPrimes;
        if (prime1.length >= prime2.length) {
            minPrimes = prime2.length;
        }
        else {
            minPrimes = prime1.length;
        }
        for (int i = 0; i < minPrimes;) {
            if (prime1[i] != 0 && prime2[i] != 0) {
                prime1[i]--;
                prime2[i]--;
                reduced[0][0] = reduced[0][0]/i;
                reduced[0][1] /=i;
            }
            else {
                i++;
            }
        }
        if (minus) {
            reduced[0][0] *= -1;
        }
        return reduced;
    }
    //Функция для проверки суммы всех дробей
    public static void Check (long fractions[][],String str) {
        System.out.print(str);
        double summ = 0;
        for (int i = 0; i < fractions.length; i++) {
            System.out.print(fractions[i][0] + "/" + fractions[i][1] + ", ");
            summ += ((double) fractions[i][0])/((double) fractions[i][1]);
        }
        System.out.println();
        System.out.println("общая сумма дробей: " + summ);
    }
    //Сокращение дробей
    public static long[][] reduction (long arr [][]) {
        long reducted [][] = new long [1][2];
        for (int i = 0; i < arr.length; i++) {
            reducted [0][0] = arr[i][0];
            reducted [0][1] = arr[i][1];
            reducted = fractionReduction(reducted);
            arr[i][0] = reducted[0][0];
            arr[i][1] = reducted[0][1];
        }
        return arr;
    }
    //Сортировка Шелла
    public static long[][] shellSort (long arr [][]) {
        long buffer;
        for (int i = 0; i < arr.length-1;) {
            if (arr[i][0] > arr[i+1][0]) {
                buffer = arr[i][0];
                arr[i][0] = arr[i+1][0];
                arr[i+1][0] = buffer;
                if (i > 0) {
                    i--;
                }
            }
            else i++;
        }
        return arr;
    }
}
