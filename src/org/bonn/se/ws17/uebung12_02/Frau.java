package org.bonn.se.ws17.uebung12_02;


public class Frau extends Mensch {
    private static int anzahl; //Anzahlen der Instanzen vom Typ Frau
    private final String chromosomen = "XX";

    public Frau(String name, int alter, int koerpergroesse, int koerpergewicht) {
        super(name, alter, koerpergroesse, koerpergewicht);
        Frau.anzahl++;
    }

    public static int anzahl() {
        return Frau.anzahl;
    }

    @Override
    public String chromosomen() {
        return chromosomen;
    }

    @Override
    public int groesse() { // Frauen behaupten 5cm kleiner zu sein.
        return super.groesse() - 5;
    }

    @Override
    public int preisHaarschnitt() {
        return (int) Math.round(20.0 + (2.0 / 3.0) * super.alter());
    }
}