package org.bonn.se.ws17.uebung08_04;

public class Zahlen {
    public static boolean istPrimLoop(int p) {
        if (p < 2) {
            return false;
        }
        int n = 2;
        while (n < p) {
            if ((p % n) == 0) {
                return false;
            } else {
                n += n;
            }
        }
        return true;
    }

    public static boolean istPrimRek(int p) {
        if (p < 2) {
            return false;
        }
        return Zahlen.istPrimRek(p, 2);
    }

    private static boolean istPrimRek(int p, int n) {
        if (n == p) {
            return true;
        }
        if ((p % n) == 0) {
            return false;
        }
        return Zahlen.istPrimRek(p, n + 1);
    }
}
