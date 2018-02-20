package org.bonn.se.ws17.uebung11_04;

public class Stromvertrag {
    private static int anzahl;
    private final int nummer;
    private final String name;  // Vertragspartnername
    private final int fixKosten = 200;
    private final int variableKosten = 30;
    int monat;
    int zaehler; //(kWh letzte abrechnung Zaehlerstand)

    public Stromvertrag(String name, int monat, int zaehlerstand) {
        this.name = name;
        this.monat = monat;
        zaehler = zaehlerstand;
        Stromvertrag.anzahl++;
        nummer = Stromvertrag.anzahl();
    }

    public static int anzahl() {
        return Stromvertrag.anzahl;
    }

    public int nummer() {
        return nummer;
    }

    public int monat() {
        return monat;
    }

    public int zaehler() {
        return zaehler;
    }

    public int kostenFix(int monate) {
        return monate * fixKosten;
    }

    public int kostenVariabel(int monate, int kwh) {
        return (kwh * variableKosten);
    }

    public int rechnung(int monat, int zaehler) {
        int zeitraum = monat - this.monat;
        int newKwh = zaehler - this.zaehler;
        int kosten = kostenFix(zeitraum) + kostenVariabel(zeitraum, newKwh);
        this.monat = monat;
        this.zaehler = zaehler;
        return kosten;
    }
}