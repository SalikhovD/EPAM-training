package com.company;

public class Main {

    public static void main(String[] args) {
        String str = "556 asdad340fm kjdf2  4-v 9494nv 0212 -- 43324 w4523vc 55";
        System.out.println("Строка: " + str);
        System.out.println("В строке содержится " + numbersCount(str) + " чисел");
    }

    //Возвращает количество чисел в строке
    public static int numbersCount(String str) {
        char[] strAsChars = str.toCharArray();
        int numbersCounter = 0;
        boolean currentCharIsDigit = false;
        for (int i = 0; i < strAsChars.length; i++) {
            if (currentCharIsDigit == false && (int)strAsChars[i] >=48 && (int)strAsChars[i] <= 57) {
                currentCharIsDigit = true;
                numbersCounter++;
            }
            if (currentCharIsDigit) {
                if ((int)strAsChars[i] < 48 || (int)strAsChars[i] > 57) {
                    currentCharIsDigit = false;
                }
            }
        }
        return numbersCounter;
    }
}
