package org.bonn.se.ws17.uebung04_02;


public class Zeichenketten {
    public static String rueckwaerts(String s) {
        String ausgabe = "";
        for (int i = s.length(); i > 0; i--) {
            ausgabe += s.charAt(i - 1);
        }
        return ausgabe;
    }

    public static String einfuegen(String s, int p, String t) {
        return s.substring(0, p) + t + s.substring(p, s.length());
    }
}
