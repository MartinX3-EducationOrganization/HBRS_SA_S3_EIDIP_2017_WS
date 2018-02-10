package org.bonn.se.ws17.uebung07_05;

import org.bonn.se.ws17.uebung07_04.Zeit;

public class Datum {
    private static int anzahl;
    private static char zeichen = '-';
    private static String reihenfolge = "jmt";
    private final int jahr;
    private final int tag;
    private final int monat;

    public Datum() {
        jahr = 1;
        monat = 1;
        tag = 1;
        Datum.anzahl++;
    }

    public Datum(Datum o) throws Exception {
        this(o.jahr, o.monat, o.tag);

    }

    public Datum(int jahr, int monat, int tag) throws Exception {
        if (jahr < 1) {
            throw new Exception("ungueltiger Wert fuer Jahr: " + jahr);
        } else if (monat < 1 || monat > 12) {
            throw new Exception("ungueltiger Wert fuer Monat: " + monat);
        } else if (tag < 1 || tag > Zeit.tageInMonat(monat, jahr)) {
            throw new Exception("ungueltiger Wert fuer Tag: " + tag);

        } else {
            this.jahr = jahr;
            this.monat = monat;
            this.tag = tag;
            Datum.anzahl++;
        }
    }

    public static int anzahl() {
        return Datum.anzahl;
    }

    public static void setzteFormatRF(String s) throws Exception {
        switch (s) {
            case "jmt":
                Datum.reihenfolge = s;
                break;
            case "tmj":
                Datum.reihenfolge = s;
                break;
            case "mtj":
                Datum.reihenfolge = s;
                break;
            default:
                throw new Exception("ungueltiger Wert fuer Format-Reihenfolge: " + '\"' + s + '\"');
        }
    }

    public static void setzeFormatTZ(char z) throws Exception {
        if (Character.isDigit(z) && z != '0') {
            throw new Exception("ungueltiger Wert fuer Format-Trennzeichen: " + '\'' + z + '\'');
        }
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

    public boolean equals(Datum o) {
        return (jahr == o.jahr && monat == o.monat && tag == o.tag);
    }

    public boolean istFrueher(Datum o) {
        return (o.jahr > jahr ||
                (o.jahr == jahr && o.monat > monat) ||
                (o.jahr == jahr && o.monat == monat && o.tag > tag));
    }

    @Override
    public String toString() {
        String s = "";
        try {
            switch (Datum.reihenfolge) {

                case "tmj":
                    if (Datum.zeichen == '0') {
                        s = "" + tag + ". " + Zeit.nameVonMonat(monat) + " " + jahr;
                    } else {
                        s = "" + tag + Datum.zeichen + monat + Datum.zeichen + jahr;
                    }
                    break;
                case "mtj":
                    if (Datum.zeichen == '0') {
                        s = "" + Zeit.nameVonMonat(monat) + " " + tag + ". " + jahr;
                    } else {
                        s = "" + monat + Datum.zeichen + tag + Datum.zeichen + jahr;
                    }
                    break;

                // jmt ist deefault laut Aufgabe
                default:
                    if (Datum.zeichen == '0') {
                        s = "" + jahr + " " + Zeit.nameVonMonat(monat) + " " + tag + ".";
                    } else {
                        s = "" + jahr + Datum.zeichen + monat + Datum.zeichen + tag;
                    }
                    break;
            }


        } catch (Exception e)

        {

        }
        return s;
    }

}