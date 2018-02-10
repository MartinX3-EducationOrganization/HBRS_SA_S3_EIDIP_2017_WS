package org.bonn.se.ws17.uebung06_01;

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

    public Datum(int jahr, int monat, int tag) {
        this.jahr = jahr;
        this.monat = monat;
        this.tag = tag;
        Datum.anzahl++;
    }

    public static int anzahl() {
        return Datum.anzahl;
    }

    public static void setzteFormatRF(String s) {
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
                break;
        }
    }

    public static void setzteFormatTZ(char c) {
        Datum.zeichen = c;
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

}