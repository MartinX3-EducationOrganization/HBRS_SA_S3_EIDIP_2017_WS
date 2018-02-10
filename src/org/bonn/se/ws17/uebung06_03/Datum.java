package org.bonn.se.ws17.uebung06_03;

public class Datum {

    private static char zeichen = '-';
    private static String reihenfolge = "jmt";
    private static int anzahl;
    private int jahr;
    private int monat;
    private int tag;


    public Datum() {
        jahr = 1;
        monat = 1;
        tag = 1;
        Datum.anzahl++;

    }

    public Datum(int jahr, int monat, int tag) {
        this.jahr = jahr;
        this.monat = monat;
        this.tag = tag;
        Datum.anzahl++;
    }

    // Gibt die Anzahl der erzeugen Objekte (Datum) wieder.
    public static int anzahl() {
        return Datum.anzahl;
    }

    // Set Methode um Ausgabeformat zu setzten
    public static void setzeFormatRF(String z) {
        Datum.reihenfolge = z;

    }

    // Set Methode um Verbindungszeichen zu setzten
    public static void setzeFormatTZ(char z) {
        Datum.zeichen = z;

    }

    public int jahr() {
        return jahr;
    }

    public int monat() {
        return monat;
    }

    public int tag() {
        return tag;
    }

    @Override
    public String toString() {
        String s = "";
        switch (Datum.reihenfolge) {

            case "jmt":
                s = "" + jahr + Datum.zeichen + monat + Datum.zeichen + tag;
                break;
            case "tmj":
                s = "" + tag + Datum.zeichen + monat + Datum.zeichen + jahr;
                break;
            case "mtj":
                s = "" + monat + Datum.zeichen + tag + Datum.zeichen + jahr;
                break;
        }
        return s;
    }

    public boolean equals(Datum o) {
        return (o.jahr == jahr & o.monat == monat & o.tag == tag);
    }

    public boolean istFrueher(Datum o) {
        return (o.jahr > jahr ||
                (o.jahr == jahr && o.monat > monat) ||
                (o.jahr == jahr && o.monat == monat && o.tag > tag));

    }

    // Aufgabenteil 3
    // Idee Wir schauen was das Max an Tagen in dem Monat ist und gehen in nächsten falls größer. (Nur Obergrenze)
    public Datum tagPlus() {
        int maxTageInMonat = Zeit.tageInMonat(monat, jahr);
        // Wenn die MaxTage im Monat erreicht sind und ggf. der Monat oder der Monat und Jahr geändert werden müssen.
        if (tag == maxTageInMonat) {
            tag = 1;
            // Check ob Monat Dezember
            if (monat == 12) {
                monat = 1;
                jahr = jahr + 1;
            } else {
                monat = monat + 1;
            }

            // Wenn Jahr und Monat gleich bleibt
        } else {
            tag = tag + 1;
        }
        return this;
    }

    // Gleiche Idee wie tagPlus nur in die andere Richtung !Monat vorher muss überprüft werden!
    public Datum tagMinus() {
        if (tag == 1 && monat == 1) {
            tag = 31;
            monat = 12;
            jahr = jahr - 1;
        } else if (tag == 1 && monat > 1) {
            // Wichtig monat - 1 => Wir überprüfen den Monat zuvor.
            tag = Zeit.tageInMonat(monat - 1, jahr);
            monat = monat - 1;
        } else {
            tag = tag - 1;
        }
        return this;
    }

    public Datum monatPlus() {
        if (monat == 12) {
            // Dez. Jan. beide 31 Tage.
            monat = 1;
            jahr = jahr + 1;
        } else {
            monat = monat + 1;
            if (tag > Zeit.tageInMonat(monat, jahr)) {
                tag = Zeit.tageInMonat(monat, jahr);
            }
        }
        return this;
    }

    public Datum monatMinus() {
        if (monat == 1) {
            monat = 12;
            jahr = jahr - 1;
        } else {
            monat = monat - 1;
            if (tag > Zeit.tageInMonat(monat, jahr)) {
                tag = Zeit.tageInMonat(monat, jahr);
            }
        }
        return this;
    }

    public Datum jahrPlus() {
        jahr = jahr + 1;
        if (tag > Zeit.tageInMonat(monat, jahr)) {
            tag = Zeit.tageInMonat(monat, jahr);
        }

        return this;
    }

    public Datum jahrMinus() {
        jahr = jahr - 1;
        if (tag > Zeit.tageInMonat(monat, jahr)) {
            tag = Zeit.tageInMonat(monat, jahr);
        }
        return this;
    }

}