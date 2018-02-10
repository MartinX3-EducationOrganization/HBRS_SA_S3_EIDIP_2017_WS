package org.bonn.se.ws17.uebung06_02;

import org.bonn.se.ws17.uebung06_03.Datum;
import org.bonn.se.ws17.uebung06_03.Zeit;

public class DatumZeitTest {

    /**
     * Zu testen sind die Klassen und Methoden aus Blatt 6, Aufgabe 3 *
     * Klasse Zeit, Methode : istSchaltjahr (aus Übung vorher), tageInMonat
     * Klasse Datum, Methoden : equals, tagePlus, tageMinus, monatPlus, monatMinus, jahrPlus, jahrMinus
     */

    public static boolean test() {

        return (DatumZeitTest.istSchaltjahrTest() & DatumZeitTest.tageInMonatTest() & DatumZeitTest.datumEqualsCheck() & DatumZeitTest.tageTest() & DatumZeitTest.monatTest() & DatumZeitTest.jahrTest() & DatumZeitTest.methodenTest()

        );

    }


    /**
     * Test Klasse Zeit, istSchaltjahr & tageInMonat.
     */
    private static boolean istSchaltjahrCheck(int jahr, boolean ist) {

        return (ist == Zeit.istSchaltjahr(jahr));
    }


    private static boolean istSchaltjahrTest() {
        return (DatumZeitTest.istSchaltjahrCheck(2000, true)
                & DatumZeitTest.istSchaltjahrCheck(1700, false)       // Durch 4 teilbar aber auch durch 100 somit kein Schaltjahr
                & DatumZeitTest.istSchaltjahrCheck(2001, false)       // Nicht durch 4 , 100 oder 400 teilbar.
                & DatumZeitTest.istSchaltjahrCheck(1704, true)        // Durch 4 teilbar aber nicht durch 100 oder 400.
                & DatumZeitTest.istSchaltjahrCheck(1400, true)        // Vor 1583 somit muss nur durch 4 Teilbar sein. Somit true.
                & DatumZeitTest.istSchaltjahrCheck(1579, false)       // Vor 1583 nicht durch 4 teilbar somit kein Schaltjahr.
                & DatumZeitTest.istSchaltjahrCheck(1584, true)
                & DatumZeitTest.istSchaltjahrCheck(1582, false)       // Nicht durch 4 teilbar somit kein Schaltjahr
                & DatumZeitTest.istSchaltjahrCheck(1404, true)        // Durch 4 teilbar vor 1583 (nicht durch 100) somit auch Schaltjahr.
                & DatumZeitTest.istSchaltjahrCheck(-1, false)       // -1 dazu genommen auch wenn steht nur possitive Jahreszahlen
                & DatumZeitTest.istSchaltjahrCheck(1, false)        // Test Jahreszahl 1, somit false.
                & DatumZeitTest.istSchaltjahrCheck(-4, true)        // ka was noch zu testen sein soll.
                & DatumZeitTest.istSchaltjahrCheck(0, true));         // Test bei 0 ergibt True, da keine Ausnahhme erfordert war.


    }

    private static boolean tageInMonatCheck(int monat, int jahr, int erwartet) {
        return (erwartet == Zeit.tageInMonat(monat, jahr));
    }

    private static boolean tageInMonatTest() {
        return (DatumZeitTest.tageInMonatCheck(1, 2001, 31)             // Test ob die Tage für alle 12 Monate stimmen. (kein Schaltjahr)
                & DatumZeitTest.tageInMonatCheck(2, 2001, 28)
                & DatumZeitTest.tageInMonatCheck(3, 2001, 31)
                & DatumZeitTest.tageInMonatCheck(4, 2001, 30)
                & DatumZeitTest.tageInMonatCheck(5, 2001, 31)
                & DatumZeitTest.tageInMonatCheck(6, 2001, 30)
                & DatumZeitTest.tageInMonatCheck(7, 2001, 31)
                & DatumZeitTest.tageInMonatCheck(8, 2001, 31)
                & DatumZeitTest.tageInMonatCheck(9, 2001, 30)
                & DatumZeitTest.tageInMonatCheck(10, 2001, 31)
                & DatumZeitTest.tageInMonatCheck(11, 2001, 30)
                & DatumZeitTest.tageInMonatCheck(12, 2001, 31)
                & DatumZeitTest.tageInMonatCheck(2, 2004, 29)       //Test ob Feb. im Schaltjahr 29 Tage hat. Alle Schaltjahre übprüfen macht schon istSchaltjahr.
        );
    }

    /**
     * Test der Klasse Datum
     */

    //  Bei verändertem Datum Tag,Monat,Jahr auf Ungleichheit getestet und bei gleichen Datum auf Gleichheit
    private static boolean datumEqualsCheck() {
        Datum a = new Datum(2000, 1, 1);
        return (a.equals(new Datum(2000, 1, 1)) &&
                (!a.equals(new Datum(2000, 1, 2))) &&
                (!a.equals(new Datum(2000, 2, 1))) &&
                (!a.equals(new Datum(2001, 1, 2))));
    }

    private static boolean tageTest() {
        Datum neuJahr = new Datum(2000, 1, 1);  //1. Januar gewählt & 31. Dez gewählt wegen Jahreswechsel
        Datum silvester = new Datum(1999, 12, 31);
        Datum febS = new Datum(2004, 2, 29);  // Letzter Tag im Februar (im Schaltjahr)
        Datum maerzS = new Datum(2004, 3, 1); // Erster Tag im März (im Schaltjahr)
        Datum febR = new Datum(2003, 2, 28);
        Datum maerzR = new Datum(2003, 3, 1);
        Datum juni = new Datum(2002, 6, 10);
        Datum juniMinus = new Datum(2002, 6, 9);
        Datum juliEnde = new Datum(2002, 7, 31);
        Datum augustAnfang = new Datum(2002, 8, 1);

        return (neuJahr.tagMinus().equals(silvester) &
                silvester.tagPlus().equals(new Datum(2000, 1, 1)) &
                maerzS.tagMinus().equals(febS) &
                febS.tagPlus().equals(new Datum(2004, 3, 1)) &
                maerzR.tagMinus().equals(febR) &
                febR.tagPlus().equals(new Datum(2003, 3, 1)) &
                juni.tagMinus().equals(juniMinus) &
                juniMinus.tagPlus().equals(new Datum(2002, 6, 10)) &
                juliEnde.tagPlus().equals(augustAnfang) &
                augustAnfang.tagMinus().equals(new Datum(2002, 7, 31)));


    }

    private static boolean monatTest() {
        Datum jan = new Datum(2000, 1, 1);
        Datum dez = new Datum(1999, 12, 1);
        Datum febS = new Datum(2004, 2, 29);
        Datum febR = new Datum(2003, 2, 28);
        Datum maerzS = new Datum(2004, 3, 31);
        Datum maerzR = new Datum(2003, 3, 31);
        Datum janR = new Datum(2003, 1, 31);
        Datum janS = new Datum(2004, 1, 31);
        Datum juniEnde = new Datum(2003, 7, 31);

        return (jan.monatMinus().equals(dez) &      // Übergang Monat zw. Jan und Dez.
                dez.monatPlus().equals(new Datum(2000, 1, 1)) &
                maerzS.monatMinus().equals(febS) &
                maerzR.monatMinus().equals(febR) &
                janR.monatPlus().equals(febR) &
                janS.monatPlus().equals(febS) &
                juniEnde.monatMinus().equals(new Datum(2003, 6, 30))  // 31-> 30 -

        );

    }

    private static boolean jahrTest() {
        Datum febS = new Datum(2004, 2, 29);
        Datum febR = new Datum(2003, 2, 28);
        Datum feb = new Datum(2005, 2, 28);
        Datum febA = new Datum(2004, 2, 29);

        return (febS.jahrMinus().equals(febR) &
                febA.jahrPlus().equals(feb)
        );

    }

    private static boolean methodenTest() {
        Datum o = new Datum();
        return (o.jahr() == 1 &
                o.monat() == 1 &
                o.tag() == 1 &
                o.equals(new Datum(1, 1, 1)));
    }
}