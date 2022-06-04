package com.company;

public class Main {

    public static void main(String[] args) {
        //Создаем число
        int num = (int) (Math.random()*2000000000);
        System.out.println("Сгенерированное число: "+num);

        //Преобразуем число в массив цифр
        int digits[] = toDigitsArr(num);

        //Проверяем, что получилось
        System.out.println("Элементы полученного массива: ");
        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[i]);
        }
    }

    //Функция возвращает массив цифр, из которых состоит число
    public static int[] toDigitsArr (int num) {
        int digits[] = new int[(int) (Math.log10(num))+1];
        for (int i = (int) (Math.log10(num)); i >= 0; i--) {
            digits[i] = num%10;
            num /=10;
        }
        return digits;
    }
}
