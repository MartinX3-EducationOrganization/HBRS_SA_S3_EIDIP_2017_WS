package org.bonn.se.ws17.uebung07_03;

import org.bonn.se.ws17.uebung06_03.Zeit;

public class DatumMitFehler {
    public static int berechneJahr(int tage) {
        int jahr = 1980; // 01.01.1980 ist Tag 1
        while (tage > 365) {
            if (Zeit.istSchaltjahr(jahr)) {
                if (tage > 365) { // > 365 nicht 366 oder >= 366
                    tage = tage - 366;
                    jahr = jahr + 1;
                }
            } else {
                tage = tage - 365;
                jahr = jahr + 1;
            }
        }
        return jahr;
    }
}
