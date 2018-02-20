package org.bonn.se.ws17.uebung11_05;

import org.bonn.se.ws17.uebung11_04.Stromvertrag;

public class StromvertragMenge extends Stromvertrag {
    private static int anzahl;
    private int fixKosten = 0;
    private int variableKosten = 28;

    public StromvertragMenge(String name, int monat, int zaehlerstand) {
        super(name, monat, zaehlerstand);
        StromvertragMenge.anzahl++;
    }

    public static int anzahl() {
        return StromvertragMenge.anzahl;
    }

    @Override
    public int kostenFix(int monate) {
        return 0;
    }

    @Override
    public int kostenVariabel(int monate, int kwh) {

        if (kwh / monate >= 1000) {
            fixKosten = 0;
            variableKosten = 28;
        } else {
            kwh = monate * 1000;
        }
        return kwh * variableKosten;
    }
}