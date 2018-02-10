package org.bonn.se.ws17.uebung07_02;


import java.util.Scanner;

public class Zahlen {
    public static int min(int a, int b, int c, int d) {
        return Math.min(Math.min(a, b), Math.min(c, d));
    }

    public static int mean(int a, int b, int c, int d) {
        return (a + b + c + d) / 4;
    }

    public static int nextToMean(int a, int b, int c, int d) {
        int mean = Zahlen.mean(a, b, c, d);
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

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            System.out.println("Eingabe: " + a + " " + b + " " + c + " " + d);
            System.out.println("Minimum: " + Zahlen.min(a, b, c, d));
            System.out.println("Mittelwert: " + Zahlen.mean(a, b, c, d));
            System.out.println("am naechsten am Mittelwert: " + Zahlen.nextToMean(a, b, c, d));
        }
        sc.close();
    }
}
