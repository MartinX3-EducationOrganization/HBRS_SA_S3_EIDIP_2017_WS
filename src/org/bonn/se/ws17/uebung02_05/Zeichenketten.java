package org.bonn.se.ws17.uebung02_05;


public class Zeichenketten {
    public static String halloMitZeit(int stunde, String name) {

        if (stunde < 12) {
            return String.format("Guten Morgen, %s !", name);
        } else if (stunde >= 18) {
            return String.format("Guten Abend, %s !", name);
        } else {
            return String.format("Guten Tag, %s !", name);
        }
    }

    public static String zitronenEis(int n) throws Exception {
        if (n < 0) {
            throw new Exception("Keine negativen Zahlen!");
        }
        String s = "", z = "";
        for (int i = 0; i < n; i++) {
            s += "super";
            z += "Z";
        }
        return String.format("%sleckers %sZitroneneis", s, z);
    }
}
