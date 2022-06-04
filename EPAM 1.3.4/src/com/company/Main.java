package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger result = new BigInteger("1");

        for (int i = 1; i <= 200; i++) {
            result = result.multiply(BigInteger.valueOf(i*i));
        }
        System.out.println(result);
    }
}
