package com.company;

public class Main {

    public static void main(String[] args) {
	double [] a = {0,0};
	double [] b = {5,3};
	double [] c = {15,9};

	if (((b[0]-a[0])*(c[1]-a[1])-(c[0]-a[0])*(b[1]-a[1]))/2 == 0)
		System.out.println("Точки лежат на одной прямой");
	else System.out.println("Точки НЕ лежат на одной прямой");
	    }
}
