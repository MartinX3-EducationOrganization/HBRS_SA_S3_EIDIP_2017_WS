package org.bonn.se.ws17.uebung04_04;


public class Zeichenketten {
    public static String verkuerze(String s, int n) {
        String ausgabe = "";
        ausgabe = s.substring(0, n) + "[...]" + s.substring(s.length() - n, s.length());
        return (ausgabe.length() < s.length()) ? ausgabe : s;
    }
}
