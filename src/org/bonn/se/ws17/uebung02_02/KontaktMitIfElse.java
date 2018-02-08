package org.bonn.se.ws17.uebung02_02;


public class KontaktMitIfElse {
    public static String hallo(String sprache, String name) {
        String gruss;
        if (sprache.equals("Englisch")) {
            gruss = "Hello";
        } else if (sprache.equals("Spanisch")) {
            gruss = "Hola";
        } else if (sprache.equals("Deutsch")) {
            gruss = "Hallo";
        } else {
            return String.format("FEHLER: Sprache '%s' nicht bekannt!", sprache);
        }
        return gruss + " " + name + " !";
    }

    public static String bye(String sprache, String name) {
        String bye;
        if (sprache.equals("Englisch")) {
            bye = "Bye";
        } else if (sprache.equals("Spanisch")) {
            bye = "Chao";
        } else if (sprache.equals("Deutsch")) {
            bye = "Tschuess";
        } else {
            return String.format("FEHLER: Sprache '%s' nicht bekannt!", sprache);
        }
        return bye + " " + name + " !";
    }

}
