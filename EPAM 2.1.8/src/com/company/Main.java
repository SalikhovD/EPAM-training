package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //Создаем и наполняем исходный массив
        int n = (int) (Math.random()*999+1);
        System.out.println("Значений в списке: " + n);
        for (int i = 0; i < n; i++) {
            list1.add((int) (Math.random()*500)-250);
        }

        //Вычисляем значение минимального элемента
        int min = list1.get(0);
        for (int i = 1; i < n; i++) {
            if (list1.get(i) < min) {
                min = list1.get(i);
            }
        }
        System.out.println("Минимальное значение: " + min);

        //Записываем новый массив, исключая элементы, равные минимальному
        for (int i = list1.size()-1; i >= 0; i--) {
            if (list1.get(i) == min) {
                list1.remove(i);
                System.out.println("Значение удалено");
            }
        }
        System.out.println("Значений в листе осталось:" + list1.size());

    }
}
