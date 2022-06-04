package com.company;

public class Main {

    public static void main(String[] args) {
        //Создаем числа
        int num1 = 1123345;
        int num2 = 12346576;
        System.out.println("Первое число: "+num1);
        System.out.println("Второе число: "+num2);

        //Сравнивает количество цифр в числе
        if (compareDigitsQuantity(num1,num2) == 0)
            System.out.println("Цифр в первом числе больше, чем во втором");
        else if (compareDigitsQuantity(num1,num2) == 1)
            System.out.println("Цифр во втором числе больше, чем в первом");
        else
            System.out.println("Цифр в обоих числах одинаковое количество");
    }

    //Возвращает 0, если цифр больше в первом числе, 1 - если во втором, 2 - если цифр одинаковое количество
    public static int compareDigitsQuantity (int num1, int num2) {
        if ((int)(Math.log10(num1))>(int)(Math.log10(num2)))
            return 0;
        else if ((int)(Math.log10(num1))<(int)(Math.log10(num2)))
            return 1;
        else
            return 2;
    }
}
