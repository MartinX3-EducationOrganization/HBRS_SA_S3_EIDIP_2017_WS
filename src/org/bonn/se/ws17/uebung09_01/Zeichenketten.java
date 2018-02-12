package org.bonn.se.ws17.uebung09_01;

public class Zeichenketten {
    public static boolean istPalindromLoop(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int lastpos = s.length() - 1;
        int mitte = s.length() / 2;
        for (int i = 0; i < mitte; i++) {
            if (s.charAt(i) != s.charAt(lastpos - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean istPalindromRek(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        return Zeichenketten.istPalindromRek(s, 0);
    }

    public static boolean istPalindromRek(String s, int index) {
        int lastpos = s.length() - 1;
        int mitte = s.length() / 2;
        if (index < mitte) {
            if (s.charAt(index) != s.charAt(lastpos - index)) {
                return false;
            }
            return Zeichenketten.istPalindromRek(s, index + 1);
        }
        return true;
    }
}
