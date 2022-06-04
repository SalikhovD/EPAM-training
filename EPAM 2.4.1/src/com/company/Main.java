package com.company;

public class Main {

    public static void main(String[] args) {
        int a = (int) (Math.random()*100+1);
        int b = (int) (Math.random()*100+1);
        int lcm = lcm(a,b);
        int gcd = gcd(a,b);
        System.out.println("Снегерированные числа: " + a + " ," + b);
        System.out.println("НОК: " + lcm);
        System.out.println("НОД: " + gcd);
    }
    //Вычисление НОК по алгоритму Евклида
    public static int lcm (int a, int b) {
        return (a*b)/gcd(a,b);
    }
    public static int gcd (int a, int b) {
        while (a!=b) {
            if (a>b) {
                a -= b;
            }
            else {
                b -= a;
            }
        }
        return a;
    }
}
