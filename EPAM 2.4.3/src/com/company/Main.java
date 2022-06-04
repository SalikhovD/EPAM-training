package com.company;

public class Main {

    public static void main(String[] args) {
        double a = Math.random()*10; //Генерируем сторону правильного шестиугольника
        //Представляем правильный шестиугольник как шесть равносторонних треугольников со стороной а, тогда S=
        double s = 6*triangleSquare(a,a,a);
        System.out.println("Площадь правильного шестиугольника со стороной " + a + " равна " + s);
    }

    //Вычисление площади треугольника по формуле Герона
    public static double triangleSquare (double a, double b, double c) {
        double P = (a+b+c)/2;
        double S = Math.sqrt(P*(P-a)*(P-b)*(P-c));
        return S;
    }
}
