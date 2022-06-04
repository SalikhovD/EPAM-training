package com.company;

public class Main {

    public static void main(String[] args) {
        String palindrome = "saippuakivikauppias";
        String notPalindrome = "qweerty";
        System.out.println(palindrome + " является полиндромом - " + isPalindrome(palindrome));
        System.out.println(notPalindrome + " является полиндромом - " + isPalindrome(notPalindrome));
    }

    public static boolean isPalindrome(String str) {
        if (str.equals(reverseString(str)))
            return true;
        else return false;
    }

    public static String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}
