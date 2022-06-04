package com.company;

public class Main {

    public static void main(String[] args) {
        String str = "Java is a high-level, class-based, object-oriented   programming language that is     designed to have as few implementation dependencies as possible. ";
        System.out.println("Строка: " + str);
        System.out.println("В этой строке пробел встречается подряд " + spaceMaxSequence(str) + " раз");
    }

    //Возвращает максимальное количество пробелов, встречающихся подряд
    public static int spaceMaxSequence (String str) {
        String spacesCounter = "";
        for (int i = 1; i < str.length(); i++) {
            spacesCounter = spacesCounter.concat(" ");
            if (str.contains(spacesCounter) == false) {
                return i-1;
            }
        }
        return str.length();
    }


}
