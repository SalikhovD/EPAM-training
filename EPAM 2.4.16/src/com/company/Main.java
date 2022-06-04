package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int n = 4; //Разрядность чисел
        int[] numbers = oddDigitNumbers(n);
        int sum = elementsSum(numbers);
        System.out.println("Сумма всех " + n + "-значных чисел, содержащих только нечетные цифрры равна " + sum);
        System.out.println("Эта сумма содержит " + evenDigitsCount(sum) + " четных цифр");

    }

    //Возвращает массив всех n-разрядных чисел, состоящих из только нечетных цифр
    public static int[] oddDigitNumbers(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num = num * 10 + 1;
        }
        int[] digits = numToDigits(num);
        ArrayList list = new ArrayList();
        list.add(num);
        int j = 0;
        while (j < digits.length) {
            if (digits[j] != 9) {
                digits[j] += 2;
                if (j > 0) {
                    for (int i = 0; i < j; i++) {
                        digits[i] = 1;
                    }
                    j = 0;
                }
                list.add(digitsToNum(digits));
            } else {
                j++;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) list.get(i);
        }
        return result;
    }

    //Возвращает массив цифр, из которых состоит число
    public static int[] numToDigits(int num) {
        int digits[] = new int[(int) (Math.log10(num)) + 1];
        for (int i = (int) (Math.log10(num)); i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    //Возвращает число, состоящие из цифр переданого массива
    public static int digitsToNum(int[] digits) {
        int num = 0;
        for (int i = 0; i < digits.length; i++) {
            num = num * 10 + digits[i];
        }
        return num;
    }

    //Возвращает сумму всех элементов массива
    public static int elementsSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //Возвращает количество четных цифр в числе
    public static int evenDigitsCount(int num) {
        int[] digits = numToDigits(num);
        int result = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 2 == 0) {
                result += 1;
            }
        }
        return result;
    }
}
