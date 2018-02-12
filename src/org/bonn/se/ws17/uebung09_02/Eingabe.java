package org.bonn.se.ws17.uebung09_02;


import java.util.Scanner;

public class Eingabe {
    public static boolean pruefeKlammern() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            if (input.equals("[") || input.equals("{") || input.equals("(")) {
                return Eingabe.pruefeRek(sc, Eingabe.setBracket(input));
            }
        }
        return false;
    }

    public static boolean pruefeRek(Scanner sc, String bracket) {
        String endbracket;
        boolean bl = true;
        if (bracket.equals("[")) {
            endbracket = "]";
        } else if (bracket.equals("{")) {
            endbracket = "}";
        } else {
            endbracket = ")";
        }
        while (sc.hasNext()) {
            String input = sc.next();
            if (input.equals("[") || input.equals("{") || input.equals("(")) {
                return Eingabe.pruefeRek(sc, Eingabe.setBracket(input));
            } else if (input.equals("]") || input.equals("}") || input.equals(")")) {
                boolean br = (input.equals(endbracket));
                if (!br) {
                    bl = false;
                }
            }
        }
        return bl;
    }

    public static String setBracket(String input) {
        switch (input) {
            case "[":
                return "[";
            case "{":
                return "{";
            case "(":
                return "(";
        }
        return "";
    }
}
