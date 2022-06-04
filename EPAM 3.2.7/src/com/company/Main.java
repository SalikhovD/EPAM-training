package com.company;

public class Main {

    public static void main(String[] args) {
        String str1 = " qqwewe er tt tqqwrt yyyy";
        str1 = deleteDuplicatesAndSpaces(str1);
        System.out.println(str1);
    }

    private static String deleteDuplicatesAndSpaces(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && str.indexOf(str.charAt(i)) == i) {
                    result += str.charAt(i);
            }
        }
        return result;
    }
}
