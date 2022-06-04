package com.company;

public class Main {

    public static void main(String[] args) {
        String str = "asdad340fm kjdf2  4-v 9494nv 0212 -- 43324 w4523vc ";
        System.out.println("Строка: " + str);
        System.out.println("В строке содержится " + digitsCount(str) + " цифр");
    }

    //Возвращает количество цифр в строке
    public static int digitsCount(String str) {
        char[] strAsChars = str.toCharArray();
        int digintsCounter = 0;
        for (int i = 0; i < strAsChars.length; i++) {
            if ((int)strAsChars[i] >=48 && (int)strAsChars[i] <= 57) {
                digintsCounter++;
            }
        }
        return digintsCounter;
    }
}
