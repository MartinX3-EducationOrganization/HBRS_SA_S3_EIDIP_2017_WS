package org.bonn.se.ws17.uebung06_03;

public class Zeit {

    public static boolean istSchaltjahr(int jahr) {
        if (jahr < 1583) {  //Julianischer Kalender
            return (jahr % 4 == 0);
        } else {
            return (((jahr % 4 == 0) && (jahr % 100 != 0)) || (jahr % 400 == 0));
        }
    }

    public static int tageInMonat(int monat, int jahr) {
        int[] tagemit30 = {4, 6, 9, 11};

        if (monat == 2 && Zeit.istSchaltjahr(jahr)) {
            return 29;
        } else if (monat == 2 && !Zeit.istSchaltjahr(jahr)) {
            return 28;
        } else {
            for (int i = 0; i < tagemit30.length; i++) {
                if (monat == tagemit30[i]) {
                    return 30;
                }
            }
        }
        return 31;
    }
}