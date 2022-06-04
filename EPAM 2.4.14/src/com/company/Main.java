package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //В формулировке задачи допущена ошибка в определении числа Армстронга
        //в данном решении реализуется поиск чисел Армтронга по определению из Википедии:
        //Число Армстронга — натуральное число, которое в данной системе счисления
        //равно сумме своих цифр, возведённых в степень, равную количеству его цифр.
        int k = 100000000;

        //Реализовано два метода поиска чисел:
        //Один простой, перебором всех чисел
        //Второй сложнее, перебором только чисел с уникальным сочетанием цифр

        //Первый метод:
//        armstriongsNum(k);

        //Второй метод:
        armstriongsNumQuick(k);
    }

    //Функция возвращает массив цифр, из которых состоит число
    public static int[] numToDigits(int num) {
        int digits[] = new int[(int) (Math.log10(num)) + 1];
        for (int i = (int) (Math.log10(num)); i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    //Возвращает true, если число является числом Армстронга
    public static boolean isArmstrong(int num) {
        if (digitsPowerSum(num) == num)
            return true;
        else
            return false;
    }

    //Выводит в консоль все числа Армстронга от 1 до k
    public static void armstriongsNum(int k) {
        long start = System.currentTimeMillis();
        System.out.println("Числа Армстронга: ");
        for (int i = 1; i <= k; i++) {
            if (isArmstrong(i))
                System.out.println(i);
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("Время выполнения обычного алгоритма: " + (double) end / 1000);
    }

    //Выводит в консоль все числа Армстронга от 1 до k. оптимизированный метод
    public static void armstriongsNumQuick(int k) {
        long start = System.currentTimeMillis();
        System.out.println("Числа Армстронга: ");
        ArrayList list = new ArrayList();
        for (int i = 1; i <= k; i++) {
            if (isNumUniq(i)) {
                if (isArmstrong(digitsPowerSum(i))) {
                    if (list.contains(digitsPowerSum(i)) == false) {
                        list.add(digitsPowerSum(i));
                    }
                }
            }
        }
        int[] armstrongsNums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            armstrongsNums[i] = (int) list.get(i);
        }
        armstrongsNums = sort(armstrongsNums);
        for (int i = 0; i < armstrongsNums.length; i++) {
            System.out.println(armstrongsNums[i]);
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("Время выполнения быстрого алгоритма: " + (double) end / 1000);
    }

    //Возвращает сумму цифр, возведенных в степень длины передаваемого числа
    public static int digitsPowerSum(int num) {
        int[] digits = numToDigits(num);
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += (int) Math.pow(digits[i], digits.length);
        }
        return sum;
    }

    //Проверяет, составляют ли цифры числа неубывающую последовательность
    public static boolean isNumUniq(int num) {
        int[] digits = numToDigits(num);
        if (digits.length == 1)
            return true;
        for (int i = 1; i < digits.length - 1; i++) {
            if (digits[i] > digits[i + 1])
                return false;
        }
        return true;
    }

    //Сортировка по возрастанию
    public static int[] sort(int[] arr) {
        int buffer;
        boolean done = false;
        while (done == false) {
            done = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    done = false;
                }
            }
        }
        return arr;
    }
}
