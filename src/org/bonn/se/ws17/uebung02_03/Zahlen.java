package org.bonn.se.ws17.uebung02_03;


public class Zahlen {
    public static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else {
            return (b > c) ? b : c;
        }
    }

    public static int maxie(int a, int b, int c) {
        int max;
        if (a > b) {
            max = a;
        } else {
            max = b;
        }
        if (max > c) {
            return max;
        } else {
            return c;
        }
    }

    public static void ausgabeQuadratRueck(int a) {
        for (int i = 0; i < a; a--) {
            System.out.println(a * a);
        }
    }
}
