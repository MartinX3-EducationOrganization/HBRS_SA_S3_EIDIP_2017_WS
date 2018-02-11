package org.bonn.se.ws17.uebung07_06;

public class Zeichenketten {

    public static boolean istName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i)) && name.charAt(i) != '-') {
                return false;
            }
        }
        return true;
    }
}