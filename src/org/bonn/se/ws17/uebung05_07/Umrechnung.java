package org.bonn.se.ws17.uebung05_07;

public class Umrechnung {
    private static double wechselkurs = 1.1686;  // Wechselkurs 1.1686 Dollar für 1 Euro

    public static double kurs() {
        return Umrechnung.wechselkurs;
    }

    public static void setKurs(double e2d) {
        Umrechnung.wechselkurs = e2d;
    }

    public static double zuDollar(double e) {
        return e * Umrechnung.wechselkurs;
    }

    public static double zuEuro(double d) {
        return d / Umrechnung.wechselkurs;
    }
}
