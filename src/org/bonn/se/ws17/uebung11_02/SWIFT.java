package org.bonn.se.ws17.uebung11_02;


public class SWIFT {
    public static String iban(String id, int blz, long kontonr) throws Exception {
        return SWIFT.landeskuerzel(id) + SWIFT.pruefzahl(SWIFT.landeskuerzel(id), SWIFT.bban(blz, kontonr)) + SWIFT.bankleitzahl(blz) + SWIFT.kontonummer(kontonr);
    }

    public static String landeskuerzel(String id) throws Exception { //Verwandelt de zu DE.
        if (id.length() != 2) {
            throw new Exception("Landeszeichen hat mehr oder weniger als 2 Ziffern!");
        } else if (Character.isDigit(id.charAt(0)) || Character.isDigit(id.charAt(1))) {
            throw new Exception("Bitte nur Zeichen keine Ziffern");
        }
        return id.toUpperCase();
    }

    public static String bankleitzahl(int blz) throws Exception { //Gibt die blz als String zurück
        if (blz < 10000000 || blz > 99999999) {
            throw new Exception("Die Bankleitzahl hat 8 Ziffern nicht mehr oder weniger.");
        }
        return Integer.toString(blz);
    }

    public static String kontonummer(long kontonr) throws Exception { //Gibt kontonummer mit füllendenen vorangehenden 0 aus.
        if (kontonr < 0 || kontonr > 9999999999L) {
            throw new Exception("Die Kontonummer darf nicht größer als 10 Ziffern besitzen. Oder Minus Zahlen enthalten. ");
        }
        return String.format("%010d", kontonr);
    }

    public static String bban(int blz, long kontonr) throws Exception { // Gibt Blz und kontonr zusammen als STRING zurück
        return SWIFT.bankleitzahl(blz) + SWIFT.kontonummer(kontonr);
    }

    public static int zahlFuerUpper(char ch) throws Exception {  // Gibt Zahlwert für Zeichen zurück
        if (Character.isLowerCase(ch)) {
            throw new Exception("Der übergebene Character: " + ch + " ist kein Großbuchstabe.");
        } else if (!Character.isLetter(ch)) {
            throw new Exception("Der übergebene Character: " + ch + " ist kein Buchstabe.");
        }
        return ch - 'A' + 10;
    }

    public static String bbanErgaenzung(String id) throws Exception { // Gibt den 6-Stelligen Anhang zurück 2stellige Zahldarstellund des Landes + 00.
        if (Character.isLowerCase(id.charAt(0)) || Character.isLowerCase(id.charAt(1))) {
            throw new Exception("Zwei Großbuchstaben");
        }
        String ll = SWIFT.landeskuerzel(id); // Korriegiert Kleinbuchstaben
        int a = SWIFT.zahlFuerUpper(ll.charAt(0));  //  Gibt ersten Buchstaben an zahlFuerUpper weiter ...
        int b = SWIFT.zahlFuerUpper(ll.charAt(1));

        return Integer.toString(a) + Integer.toString(b) + "00";
    }

    public static int zahlAlsStringMod97(String ziffern) {
        if (ziffern.length() < 9) {
            String rest = ziffern.substring(0, ziffern.length());
            int letztesStueck = Integer.parseInt(rest) % 97; // letzter Modulo Schritt
            return letztesStueck;
        }
        String anfang = ziffern.substring(0, 9);
        String ende = ziffern.substring(9);
        long a = Long.parseLong(anfang) % 97;
        return SWIFT.zahlAlsStringMod97(String.valueOf(a) + ende);
    }

    public static String pruefzahl(String id, String bban) throws Exception {
        int pruefzahl = 98 - SWIFT.zahlAlsStringMod97(bban + SWIFT.bbanErgaenzung(id)); // 98 - Modulo Rest aus zahlAlsStringMod97
        String pz = Integer.toString(pruefzahl); // pz = Prüfziffer int -> String.
        if (pz.length() < 2) {  //String.format geht nicht!
            pz = 0 + pz;
        }
        return pz;
    }
}