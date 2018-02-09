package org.bonn.se.ws17.uebung07_02;

import java.util.Scanner;

public class ZahlenFalsch {
    public static int min(int a, int b, int c, int d) {
        int min = 0;
        if (a < b) {
            min = a;
        }
        if (b < c) {
            min = b;
        }
        if (c < d) {
            min = c;
        } else {
            min = d;
        }
        return min;
    }

    public static int mean(int a, int b, int c, int d) {
        return a + b + c + d / 4;
    }

    public static int nextToMean(int a, int b, int c, int d) {
        int mean = ZahlenFalsch.mean(a, b, c, a);
        int ergebnis = a;
        if (Math.abs(a) < Math.abs(b) & Math.abs(b) < Math.abs(mean) |
                Math.abs(a) > Math.abs(b) & Math.abs(b) > Math.abs(mean)) {
            ergebnis = b;
        }
        if (Math.abs(a) < Math.abs(c) & Math.abs(c) < Math.abs(mean) |
                Math.abs(a) > Math.abs(c) & Math.abs(c) > Math.abs(mean)) {
            ergebnis = c;
        }
        if (Math.abs(a) < Math.abs(d) & Math.abs(d) < Math.abs(mean) |
                Math.abs(a) > Math.abs(d) & Math.abs(d) > Math.abs(mean)) {
            ergebnis = d;
        }
        return ergebnis;
    }

    public static void eingabe() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        while (sc.hasNext()) {
            a = sc.nextInt();
            c = sc.nextInt();
            b = sc.nextInt();
            d = sc.nextInt();
            System.out.println("Eingabe: " + a + " " + b + " " + c + " " + d);
            System.out.println("Minimum: " + ZahlenFalsch.min(a, d, c, b));
            System.out.println("Mittelwert: " + ZahlenFalsch.mean(a, b, c, d));
            System.out.println("am naechsten am Mittelwert: " + ZahlenFalsch.nextToMean(a, b, c, d));
        }
        sc.close();
    }
}
