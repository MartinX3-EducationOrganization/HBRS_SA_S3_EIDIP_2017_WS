package org.bonn.se.ws17.uebung06_04;

public class Zahlen {
    public static int ggT(int a, int b) {
        if (a < 0) {
            return Zahlen.ggT(-a, b);
        } else if (b < 0) {
            return Zahlen.ggT(a, -b);
        } else if (b == 0) {
            return a;
        } else {
            return Zahlen.ggT(b, a % b);
        }
    }
}