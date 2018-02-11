package org.bonn.se.ws17.uebung07_06;


import org.bonn.se.ws17.uebung06_03.Datum;

public class Mensch {
    private static int anzahl;
    private final String vorname;
    private final String nachname;
    private final Datum geburtsdatum;

    public Mensch(String vorname, String nachname, Datum geburtsdatum) throws Exception {

        if (!Zeichenketten.istName(vorname)) {
            throw new Exception("ungueltiger Wert fuer Vorname: " + '\"' + vorname + '\"');
        } else if (!Zeichenketten.istName(nachname)) {
            throw new Exception("ungueltiger Wert fuer Nachname: " + '\"' + nachname + '\"');
        } else {
            this.vorname = vorname;
            this.nachname = nachname;
            this.geburtsdatum = new Datum(geburtsdatum.jahr(), geburtsdatum.monat(), geburtsdatum.tag());
            Mensch.anzahl++;
        }
    }

    public static int anzahl() {
        return Mensch.anzahl;
    }

    public String vorname() {
        return vorname;
    }

    public String nachname() {
        return nachname;
    }

    public Datum geburtsdatum() {
        return new Datum(geburtsdatum.jahr(), geburtsdatum.monat(), geburtsdatum.tag());
    }

    public int alter(Datum o) {
        int alter = 0;
        if (o.istFrueher(geburtsdatum)) {
            return alter;
        } else {
            alter = o.jahr() - geburtsdatum.jahr();
            if (o.monat() < geburtsdatum.monat()) {
                alter -= 1;
            } else if (o.monat() == geburtsdatum.monat() && o.tag() < geburtsdatum.tag()) {
                alter -= 1;
            }
        }
        return alter;
    }

    // Varaiablen vergleichen von Mensch o zu instanzinieren Mensch
    public boolean equals(Mensch o) {
        return (o.vorname.equals(vorname) && o.nachname.equals(nachname) && o.geburtsdatum.equals(geburtsdatum));
    }

    @Override
    public String toString() {
        return "Vorname: " + vorname + "\nNachname: " + nachname + "\nGeburtsdatum: " + geburtsdatum;
    }
}