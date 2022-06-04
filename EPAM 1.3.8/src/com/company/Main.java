package com.company;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	int a = 102345;
    int b = 34567890;
    char [] aChar = Integer.toString(a).toCharArray();
    char [] bChar = Integer.toString(b).toCharArray();
        ArrayList<Character> result = new ArrayList<>();


        for (int i = 0; i < aChar.length; i++) {
            for (int j = 0; j < bChar.length; j++) {
                if (aChar[i] == bChar[j])
                    if (!result.contains(aChar[i]))
                        result.add(aChar[i]);


            }

        }
        System.out.print("Совпадающие цифры: ");
        for (char c : result) {
            System.out.print(c + " ");

        }
    }
}
