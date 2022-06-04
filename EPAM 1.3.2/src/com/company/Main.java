package com.company;

public class Main {

    public static void main(String[] args) {
	double [] seg = {-5,48};
    double h = 2.5;
    double [] result = new double[(int) ((seg[1]-seg[0])/h + 1)];
        for (int i = 0; i < result.length; i++) {
            double x = seg[0] + h*i;
            if (x>2)
                result[i] = x;
            else result[i] = -x;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
