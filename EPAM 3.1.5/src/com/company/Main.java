package com.company;

public class Main {

    public static void main(String[] args) {
        String str = " Java is   a high-level,  class-based, object-oriented  programming            language that is designed to have as  few implementation dependencies  as possible.  ";
        str = deleteSpaces(str);
        System.out.println(str);
        System.out.println(str.length());
    }

    //Возвращает строку с удаленными лишними пробелами
    public static String deleteSpaces(String str) {
        char[] strAsChars = str.toCharArray();
        int spacesCounter = 0;
        int i = 0;
        while (strAsChars[i] == 32) {
            strAsChars[i] = 0;
            i++;
            spacesCounter++;
            if (i == strAsChars.length) {
                return new String("");
            }
        }
        i = strAsChars.length - 1;
        while (strAsChars[i] == 32) {
            strAsChars[i] = 0;
            i--;
            spacesCounter++;
        }
        for (i = 1; i < strAsChars.length - 1; i++) {
            if (strAsChars[i] == 32 && strAsChars[i + 1] == 32) {
                strAsChars[i] = 0;
                spacesCounter++;
            }
        }
        char[] result = new char[strAsChars.length-spacesCounter];
        i = 0;
        for (int j = 0; j < strAsChars.length; j++) {
            if ((int)strAsChars[j] == 0) {
                i++;
            } else {
                result[j-i] = strAsChars[j];
            }
        }
        return new String(result);
    }
}
