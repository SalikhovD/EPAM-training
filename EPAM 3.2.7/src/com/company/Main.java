package com.company;

public class Main {

    public static void main(String[] args) {
        String str1 = " qqwee er tt tqqwrt y";
        str1 = deleteDuplicatesAndSpaces(str1);
        System.out.println(str1);
    }

    private static String deleteDuplicatesAndSpaces(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && str.indexOf(str.charAt(i),0) == i) {
                    result += str.charAt(i);
            }
        }
        return result;
    }
}