package org.bonn.se.ws17.uebung09_05;


public class Felder {
    public static int suche(int[] f, int[] t) {
        if (t.length > f.length) {
            return -1;
        } else if (t.length == 0) {
            return 0;
        }
        for (int i = 0; i < f.length; i++) {

            //  Ersten Wert gefunden
            if (f[i] == t[0]) {
                if (Felder.isEqual(f, t, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean isEqual(int[] a, int[] b, int index) {
        int[] c = new int[b.length];

        //  Erstelle TeilArray aus a, ab Index
        for (int i = 0; i < c.length; i++) {
            c[i] = a[index + i];
        }
        for (int k = 0; k < b.length; k++) {
            if (b[k] != c[k]) {
                return false;
            }
        }
        return true;
    }
}