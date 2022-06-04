package com.company;

public class Main {

    public static void main(String[] args) {
        String str = "Java is a high-level, class-based, object-oriented   programming language that is     designed to have as few implementation dependencies as possible. ";
        System.out.println("В строке " + chCounter('a', str) + " символов 'a'");
    }

    //Возвращает количество переданых символов в переданой строке
    public static int chCounter(char ch, String str) {
        char chCount = 0;
        for (int i = 0; i <= str.lastIndexOf(ch); ) {
            chCount++;
            i = str.indexOf(ch, i) + 1;
        }
        return chCount;
    }
}
