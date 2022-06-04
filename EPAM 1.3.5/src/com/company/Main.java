package com.company;

public class Main {

    public static void main(String[] args) {
        int [] seg = {-6,20};
        double e = 0.01;
        int result = 0;
        for (int i = seg[0]; i <= seg[1]; i++) {
            if (Math.pow(2,-i)+Math.pow(3,-i) >= e)
                result ++;
        }
        System.out.println(result);
    }
}
