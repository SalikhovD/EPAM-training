package com.company;

public class Main {

    public static void main(String[] args) {
        String str = "word. one word, two word word, three wordwordword, four wor ord... word wordword-word";
        String target = "word";
        String replasement = "letter";
        str = replase(str, target, replasement);
        System.out.println(str);
    }

    //Возвращает строку с замененным target на replasement. По заданию вся работа со строками ведется как с массивом символов
    public static String replase(String str, String target, String replasement) {
        char[] strAsChars = str.toCharArray();
        char[] targetAsChars = target.toCharArray();
        char[] replasementAsChars = replasement.toCharArray();
        int targetCount = occurrencesCount(str, target);
        if (targetCount == 0) {
            return str;
        }
        char[] result = new char[strAsChars.length - (target.length() - replasement.length()) * targetCount];
        int j = 0;
        int pos;
        pos = occurrencePos(strAsChars, targetAsChars, 0);
        for (int i = 0; i < strAsChars.length; i++) {
            if (i == pos) {
                for (int k = 0; k < replasementAsChars.length; k++) {
                    result[i + k + j] = replasementAsChars[k];
                }
                j += -targetAsChars.length + replasementAsChars.length;
                i += targetAsChars.length - 1;
                pos = occurrencePos(strAsChars, targetAsChars, pos + 1);
            } else {
                result[i + j] = strAsChars[i];
            }
        }
        String resultSrt = "";
        for (int i = 0; i < result.length; i++) {
            resultSrt += result[i];
        }

        return resultSrt;
    }

    //Возвращает количество вхождений в строке
    public static int occurrencesCount(String str, String target) {
        char[] strAsChars = str.toCharArray();
        char[] targetAsChars = target.toCharArray();
        int targetsCounter = 0;
        int j = 0;
        for (int i = 0; i < strAsChars.length; i++) {
            if (strAsChars[i] == targetAsChars[j]) {
                j++;
            } else {
                j = 0;
            }
            if (j == targetAsChars.length) {
                targetsCounter++;
                j = 0;
            }
        }
        return targetsCounter;
    }

    //Возвращает номер элемента с которого начинается первое искомое вхождение с заданного элемента
    public static int occurrencePos(char[] strAsChars, char[] targetAsChars, int from) {
        for (int i = from; i < strAsChars.length; i++) {
            if (strAsChars[i] == targetAsChars[0]) {
                boolean targetFound = true;
                for (int k = 1; k < targetAsChars.length; k++) {
                    if (strAsChars[i + k] != targetAsChars[k]) {
                        targetFound = false;
                    }
                }
                if (targetFound) {
                    return i;
                }
            }
        }
        return 0;
    }
}
