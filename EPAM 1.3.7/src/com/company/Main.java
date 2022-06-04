package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите число m");
	int m = scn.nextInt();
        System.out.print("Введите число n");
    int n = scn.nextInt();
    String str = "";
    boolean prime = true;
        for (int i = m; i <= n; i++) {
            str = "";
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    str += j + ", ";
                    prime = false;
                }
            }
            if (prime == false){
                System.out.println("Делители числа " + i + ": " + str.substring(0, str.length() - 2));
                prime = true;
        }
            else System.out.println("Число " + i + " простое");

        }
    }

}
