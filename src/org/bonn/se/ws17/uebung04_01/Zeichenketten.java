package org.bonn.se.ws17.uebung04_01;


public class Zeichenketten {
    public static boolean istGanzzahl(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int anzahlBuchstaaben(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                counter++;
            }
        }
        return counter;
    }

    public static String vokaleGross(String s) {
        s = s.toLowerCase();
        String ausgabe = "";
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                ausgabe += Character.toUpperCase(x);
            } else {
                ausgabe += x;
            }
        }
        return ausgabe;
    }
}
