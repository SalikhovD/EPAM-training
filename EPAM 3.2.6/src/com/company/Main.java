package com.company;

public class Main {

    public static void main(String[] args) {
        String str1 = "qwerty";
        String str2 = duplicateChars(str1);
        System.out.println("Строка 1: " + str1);
        System.out.println("Строка 2: " + str2);
    }

    private static String duplicateChars(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i) + "" + str.charAt(i);
        }
        return result;
    }
}
