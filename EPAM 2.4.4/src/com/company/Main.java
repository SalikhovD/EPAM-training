package com.company;

public class Main {

    public static void main(String[] args) {
        //Создаем массив с точками
        int n = (int) (Math.random()*100); //Количество точек на плоскости
        double points [][] = new double[n][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = Math.random()*200-100;
            points[i][1] = Math.random()*200-100;
        }

        //Проверяем сгенерированный массив
        for (int i = 0; i < points.length; i++) {
            System.out.println("Точка " + i + ": " + points[i][0] + " / " + points[i][1]);
        }

        //Ищем максимальное растояние между парами точек
        int distantPoints[] = distantPoints(points);
        System.out.println("Максимальное растояние между точками " + distantPoints[0] + " и " + distantPoints[1]);
    }

    //Функция растояния между двумя точками
    public static double pointToPointDistance (double [][] pointsArr, int from, int to) {
        return Math.sqrt(Math.pow(pointsArr[from][0]-pointsArr[to][0],2)+Math.pow(pointsArr[from][1]-pointsArr[to][1],2));
    }
    //Функция поиска пары точек с максимальным растоянием между ними. Возвращает массив с номерами двух точек
    public static int [] distantPoints (double [][] pointArr) {
        double maxDist = 0;
        int aPoint = 0;
        int bPoint = 0;
        double dist;
        for (int i = 0; i < pointArr.length; i++) {
            for (int j = i+1; j < pointArr.length; j++) {
                dist = pointToPointDistance(pointArr,i,j);
                if (dist > maxDist) {
                    maxDist = dist;
                    aPoint = i;
                    bPoint = j;
                }
            }
        }
        System.out.println("Максимальное растояние между точками: " + maxDist);
        return new int[] {aPoint,bPoint};
    }
}