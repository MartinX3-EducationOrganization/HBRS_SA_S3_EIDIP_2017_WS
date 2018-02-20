package org.bonn.se.ws17.uebung11_04;

public class StromvertragOeko extends Stromvertrag {
    private static int anzahl;
    private final int fixKosten = 500;
    private final int variableKosten = 40;

    public StromvertragOeko(String name, int monat, int zaehlerstand) {
        super(name, monat, zaehlerstand);
        StromvertragOeko.anzahl++;
    }

    public static int anzahl() {
        return StromvertragOeko.anzahl;
    }

    @Override
    public int kostenFix(int monate) {
        return monate * fixKosten;
    }

    @Override
    public int kostenVariabel(int monate, int kwh) {
        return kwh * variableKosten;
    }
}