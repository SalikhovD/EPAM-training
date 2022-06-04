package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Задаем K и N, для которых нужно создать массив
        int K = 4;
        int N = 4000;

        //Создаем массив
        int[] arr = digitsSumArr(K, N);

        //Проверяем, что получилось
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + ":  " + digitsSum(arr[i]));
        }
    }

    //Возвращает массив цифр, из которых состоит число
    public static int[] numToDigits(int num) {
        if (num == 0) {
            return new int[1];
        }
        int digits[] = new int[(int) (Math.log10(num)) + 1];
        for (int i = (int) (Math.log10(num)); i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    //Возвращает сумму цифр числа
    public static int digitsSum(int num) {
        int digits[] = numToDigits(num);
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        return sum;
    }

    //Возвращает массив, члены которого имеют сумму цифр равную K и не больше N
    public static int[] digitsSumArr(int K, int N) {
        ArrayList<Integer> arr = new ArrayList();
        for (int i = 0; i <= N; i++) {
            if (digitsSum(i) == K) {
                arr.add(i);
            }
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}
