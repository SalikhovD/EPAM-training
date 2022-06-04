package com.company;

public class Main {

    public static void main(String[] args) {
	int T = 22364;
    int s = T%60;
    int m = (T%3600)/60;
    int h = T/3600;
    System.out.println(h + "ч " + m + "мин " + s + "с");
    }
}
