package org.bonn.se.ws17.uebung04_03;

import org.bonn.se.ws17.uebung04_04.Zeichenketten;

public class ZeichenkettenTest {

    public static boolean test() {

        String s = "Maultaschen";

        return (ZeichenkettenTest.testW(s, 1, "M[...]n") &&
                ZeichenkettenTest.testW(s, 2, "Ma[...]en") &&
                ZeichenkettenTest.testW(s, 3, "Maultaschen") &&   //Bei Gleichheit
                ZeichenkettenTest.testW(s, 4, "Maultaschen") &&
                ZeichenkettenTest.testW(s, 0, "[...]"));          //Bei 0.
    }

    public static boolean testW(String s, int p, String erwartung) {
        return (Zeichenketten.verkuerze(s, p).equals(erwartung));
    }
}
