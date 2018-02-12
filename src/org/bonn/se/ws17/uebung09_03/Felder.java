package org.bonn.se.ws17.uebung09_03;

public class Felder {
    public static boolean istHomogen(int[] a) {

        for (int i = 1; i < a.length; i++) {
            if (a[0] != a[i]) {
                return false;
            }
        }
        return true;
    }

    public static int max(int[] a) {
        int biggest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (biggest < a[i]) {
                biggest = a[i];
            }
        }
        return biggest;
    }

    public static int maxPos(int[] a) {
        int biggest = a[0];
        int biggestPos = 0;
        for (int i = 0; i < a.length; i++) {
            if (biggest < a[i]) {
                biggest = a[i];
                biggestPos = i;
            }
        }
        return biggestPos;
    }

    public static int[] max(int[] a, int[] b) throws Exception {
        if (a.length != b.length) {
            throw new Exception("Felder nicht gleich lang!");
        }
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= b[i]) {
                c[i] = a[i];
            } else {
                c[i] = b[i];
            }
        }
        return c;

    }
}