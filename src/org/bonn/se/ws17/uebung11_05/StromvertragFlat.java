package org.bonn.se.ws17.uebung11_05;

import org.bonn.se.ws17.uebung11_04.Stromvertrag;

public class StromvertragFlat extends Stromvertrag {
    private static int anzahl;
    private final int fixKosten = 10000;
    private final int variableKosten = 35;


    public StromvertragFlat(String name, int monat, int zaehlerstand) {
        super(name, monat, zaehlerstand);
        StromvertragFlat.anzahl++;
    }

    public static int anzahl() {
        return StromvertragFlat.anzahl;
    }

    @Override
    public int kostenFix(int monate) {
        return monate * fixKosten;
    }

    @Override
    public int kostenVariabel(int monate, int kwh) {
        int a = (kwh - monate * 400);
        if (a < 0) {
            return 0;
        }
        return a * variableKosten;
    }
}