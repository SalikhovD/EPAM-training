package com.company;

public class Main {


    public static void main(String[] args) {
        //Преобразовать строку camel case в snake case
        String str = "CamelCaseStringToSnakeCaseStringTransformation";
        str = camelToSnake(str);
        System.out.println(str);
    }

    //Преобразует строку camel case в snake case
    private static String camelToSnake(String str) {
        String result = Character.toLowerCase(str.charAt(0)) + "";
        for (int i = 1; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                result += str.charAt(i);
            } else {
                result += "_" + Character.toLowerCase(str.charAt(i));
            }
        }
        return result;
    }
}
