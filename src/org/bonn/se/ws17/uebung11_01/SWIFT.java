package org.bonn.se.ws17.uebung11_01;

public class SWIFT {
    public static String iban(String id, int blz, long kontonr) {
        return SWIFT.landeskuerzel(id) + SWIFT.pruefzahl(SWIFT.landeskuerzel(id), SWIFT.bban(blz, kontonr)) + SWIFT.bankleitzahl(blz) + SWIFT.kontonummer(kontonr);
    }

    public static String landeskuerzel(String id) { //Verwandelt de zu DE.
        return id.toUpperCase();
    }

    public static String bankleitzahl(int blz) { //Gibt die blz als String zurück
        return Integer.toString(blz);
    }

    public static String kontonummer(long kontonr) { //Gibt kontonummer mit füllendenen vorangehenden 0 aus.
        return String.format("%010d", kontonr);
    }

    public static String bban(int blz, long kontonr) { // Gibt Blz und kontonr zusammen als STRING zurück
        return SWIFT.bankleitzahl(blz) + SWIFT.kontonummer(kontonr);
    }

    public static int zahlFuerUpper(char ch) {  // Gibt Zahlwert für Zeichen zurück
        return ch - 'A' + 10;
    }

    public static String bbanErgaenzung(String id) { // Gibt den 6-Stelligen Anhang zurück 2stellige Zahldarstellund des Landes + 00.
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

    public static String pruefzahl(String id, String bban) {
        int pruefzahl = 98 - SWIFT.zahlAlsStringMod97(bban + SWIFT.bbanErgaenzung(id)); // 98 - Modulo Rest aus zahlAlsStringMod97
        String pz = Integer.toString(pruefzahl); // pz = Prüfziffer int -> String.
        if (pz.length() < 2) {  //String.format geht nicht!
            pz = 0 + pz;
        }
        return pz;
    }
}