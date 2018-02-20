package org.bonn.se.ws17.uebung12_02;

public class Mann extends Mensch {
    private static int anzahl; //Anzahlen der Instanzen vom Typ Frau
    private final String chromosomen = "XY";

    public Mann(String name, int alter, int koerpergroesse, int koerpergewicht) {
        super(name, alter, koerpergroesse, koerpergewicht);
        Mann.anzahl++;
    }

    public static int anzahl() {
        return Mann.anzahl;
    }

    @Override
    public String chromosomen() {
        return chromosomen;
    }

    @Override
    public int gewicht() { // Männer behaupten 5kg schwerer zu sein.
        return super.gewicht() + 5;
    }

    @Override
    public int preisHaarschnitt() {
        return (int) Math.round(10.0 + (1.0 / 4.0) * super.alter());
    }
}