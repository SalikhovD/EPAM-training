package com.company;

public class Main {

    public static void main(String[] args) {
        //Создаем массив простых чисел
        int n = 500;
        siblingsPrimes(n,n*2);
    }

    //Возвращает массив простых чисел от 0 n. поиск происходит по алгоритму Эратосфена
    public static int[] primeNumbersUpTo(int n) {
        boolean[] numbers = new boolean[n + 1];
        int primeNumbersCounter = 0;
        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = true;
        }
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i]) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (j % i == 0) {
                        numbers[j] = false;
                    }
                }
                primeNumbersCounter++;
            }
        }
        int[] primeNumbers = new int[primeNumbersCounter];
        int j = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]) {
                primeNumbers[j] = i;
                j++;
            }
        }
        return primeNumbers;
    }
    //Отсекает все элементы массива, которые не входят в заданных диапазон
    public static int[] cutArr (int[] arr, int from, int to) {
        int numbersCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= from && arr[i] <= to) {
                numbersCounter++;
            }
        }
        int[] result = new int[numbersCounter];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= from && arr[i] <= to) {
                result[j] = arr[i];
                j++;
            }
        }
        return result;
    }
    //Выводит в консоль пары простых чисел близнецов в заданом диапазоне
    public static void siblingsPrimes (int from, int to) {
        int[] primeNumbers = cutArr(primeNumbersUpTo(to),from,to);
        System.out.println("Пары простых чисел близнецов в диапазоне от " + from + " до " + to + ":");
        for (int i = 0; i < primeNumbers.length-1; i++) {
            if (primeNumbers[i] == primeNumbers[i+1]-2) {
                System.out.println(primeNumbers[i] + ", "+ primeNumbers[i+1]);
            }
        }
    }
}
