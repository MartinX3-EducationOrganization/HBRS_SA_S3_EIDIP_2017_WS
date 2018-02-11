package org.bonn.se.ws17.uebung06_04;

public class Zahlen {
    public static int ggT(int a, int b) {
        if (a < 0) {
            a = a * (-1);
        }
        if (b < 0) {
            b = b * (-1);
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}