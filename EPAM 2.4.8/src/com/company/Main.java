package com.company;

public class Main {

    public static void main(String[] args) {
	    //Создаем и наполняе массив
        int num [] = new int[(int) (Math.random()*10+6)];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random()*100);
        }

        //Проверяем сгенерированный массив
        System.out.println("Элементы массива: ");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + ", ");
        }

        //Выводим последовательную сумму трех элементов
        System.out.println();
        System.out.println("Сумма элементов 1-3: " +threeInRowSum(num,1));
        System.out.println("Сумма элементов 2-4: " +threeInRowSum(num,2));
        System.out.println("Сумма элементов 3-5: " +threeInRowSum(num,3));
    }

    public static int threeInRowSum (int [] arr, int k) {
        int result = 0;
        for (int i = k; i < Math.min(k+3, arr.length); i++) {
            result += arr[i];
        }
        return result;
    }
}
