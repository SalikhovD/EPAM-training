package com.company;

public class Main {

    public static void main(String[] args) {
        String str1 = "Java is a high level class based object oriented programming language that is designed to have as few implementation dependencies as possible";
        System.out.println("Самое длинное слово с строке: " + longestWord(str1));
    }

    private static String longestWord(String str) {
        String result = "";
        int wordLength;
        int i  = 0;
        while (i < str.length()) {
            if (str.indexOf(' ',i) >= 0) {
                wordLength = str.indexOf(' ',i)-i;
            }
            else {
                wordLength = str.length() - i;
            }
            if (wordLength > result.length()) {
                result = "";
                for (int j = i; j < i+wordLength; j++) {
                    result += str.charAt(j);
                }
            }
            i += wordLength+1;
        }
        return result;
    }
}
