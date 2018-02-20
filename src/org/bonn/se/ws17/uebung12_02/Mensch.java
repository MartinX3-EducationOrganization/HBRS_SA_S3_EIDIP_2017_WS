package org.bonn.se.ws17.uebung12_02;

public abstract class Mensch {
    private static int anzahl; //Anzahlen der Instanzen vom Typ Mensch
    private final String name;
    private String chromosomen;
    private int alter, koerpergroesse, koerpergewicht;  //Größe und Gewicht ganzzählig (Kg, cm)


    public Mensch(String name, int alter, int koerpergroesse, int koerpergewicht) {
        this.name = name;
        setAlter(alter);
        setGroesse(koerpergroesse);
        setGewicht(koerpergewicht);
        Mensch.anzahl++;
    }

    public static int anzahl() {
        return Mensch.anzahl;
    }

    public static int volljaehrigkeitsAlter() {
        return 18;
    }

    public abstract String chromosomen();

    public abstract int preisHaarschnitt();

    public String name() {
        return name;
    }

    public int alter() {
        return alter;
    }

    public int groesse() {
        return koerpergroesse;
    }

    public int gewicht() {
        return koerpergewicht;
    }

    void setAlter(int alter) {
        this.alter = alter;
    }

    void setGroesse(int koerpergroesse) {
        this.koerpergroesse = koerpergroesse;
    }

    void setGewicht(int koerpergewicht) {
        this.koerpergewicht = koerpergewicht;
    }

    public boolean istVolljaehrig() {
        return alter >= Mensch.volljaehrigkeitsAlter();
    }

    @Override
    public String toString() {
        return "" + name() + " " + chromosomen() + " " + alter() + " " + istVolljaehrig() + " " + groesse() + " " + gewicht() + " " + preisHaarschnitt();
    }
}