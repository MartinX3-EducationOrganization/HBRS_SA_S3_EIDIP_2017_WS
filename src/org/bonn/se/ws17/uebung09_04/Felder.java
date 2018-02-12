package org.bonn.se.ws17.uebung09_04;


public class Felder {
    public static int[] umkehren(int[] a) {
        int[] b = new int[a.length];
        int k = b.length - 1;
        for (int i : a) {
            b[k] = i;
            k--;
        }
        return b;
    }

    public static void umkehrenInPlace(int[] a) {
        int[] b = Felder.umkehren(a);
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
    }
}