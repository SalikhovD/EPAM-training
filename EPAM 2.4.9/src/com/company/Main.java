package com.company;

public class Main {

    public static void main(String[] args) {
        //Задаем стороны четырехугольника
        double X = 10;
        double Y = 15;
        double Z = 12;
        double T = 17;

        //Проверяем, существует ли такой четырехугольник и вычисляем его площадь
        if ((Z+T)<hypotenuse(X,Y)) {
            System.out.println("Четырехугольника с такими сторонами не существует");
        }
        else {
            double S = quadrilateralSquare(X,Y,Z,T);
            System.out.println("Площадь четырехугольника равна " + S);
        }
    }

    //Возвращает площадь треугольника по трем его сторонам
    public static double triangleSquare (double a, double b, double c) {
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    //Возвращает площадь прямоугольного треугольника по двум катетам
    public static double rightTriangleSquare (double a, double b) {
        return a*b/2;
    }
    //Возвращает гипотенузу прямоугольного треугольника по двум катетам
    public static double hypotenuse (double a, double b) {
        return Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
    }
    //Возвращает площадь выпуклого четырехугольника по четырем сторонам, угол между X и Y прямой
    public static double quadrilateralSquare (double X, double Y, double Z, double T) {
        return rightTriangleSquare(X,Y)+triangleSquare(Z,T,hypotenuse(X,Y));
    }
}
