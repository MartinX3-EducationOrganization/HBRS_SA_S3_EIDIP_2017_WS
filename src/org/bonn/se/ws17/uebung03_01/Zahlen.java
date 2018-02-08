package org.bonn.se.ws17.uebung03_01;

// n : always positive
public class Zahlen {
    public static int fakultaet(int n) {
        int fak = n;
        if (n <= 1) {
            return 1;
        }
        while (n > 1) {
            fak *= (n - 1);
            n--;
        }
        return fak;
    }
}
