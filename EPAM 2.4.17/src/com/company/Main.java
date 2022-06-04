package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int num = 12345;
        System.out.println("Для числа " + num + " нужно сделать " + digitsSumSubstractionCount(num) + " вычитаний сумм цифр, чтобы получить 0");
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

    //Возвращает сумму цифр, из которых состоит число
    public static int digitsSum (int num) {
        int[] digits = numToDigits(num);
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        return sum;
    }

    //Вычитает из числа сумму его цифр до тех пор, пока чисто не станет равно 0. Возвращает количество таких вычитаний
    public static int digitsSumSubstractionCount (int num){
        int substractionCounter = 0;
        while (num != 0) {
            num -= digitsSum(num);
            substractionCounter++;
        }
        return substractionCounter;
    }
}
