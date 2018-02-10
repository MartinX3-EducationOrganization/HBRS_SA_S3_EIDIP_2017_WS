package org.bonn.se.ws17.uebung07_04;


import java.util.Arrays;
import java.util.List;

public class Zeit {

    private static final String[] monate = {"Januar", "Februar", "Maerz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};

    public static boolean istSchaltjahr(int jahr) throws Exception {
        if (jahr < 0) {
            throw new Exception("ungueltigeer Wert fuer Jahr: " + jahr);
        }
        if (jahr < 1583) {
            return (jahr % 4 == 0);
        } else {
            return (((jahr % 4 == 0) && (jahr % 100 != 0)) || (jahr % 400 == 0));
        }
    }

    public static int tageInMonat(int monat, int jahr) throws Exception {
        int[] tagemit30 = {4, 6, 9, 11};
        if (monat < 1 || monat > 12) {
            throw new Exception("ungueltiger Wert fuer Monat: " + monat);
        } else if (jahr <= 0) {
            throw new Exception("ungueltiger Wert fuer Jahr: " + jahr);
        }

        if (monat == 2 && Zeit.istSchaltjahr(jahr)) {
            return 29;
        } else if (monat == 2 && Zeit.istSchaltjahr(jahr)) {
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

    public String nameVonMonat(int monat) throws Exception {
        if (monat < 1 || monat > 12) {
            throw new Exception("ungueltiger Wert fuer Monat " + monat);
        } else {
            return Zeit.monate[monat - 1];
        }
    }

    public int tageVonMonat(String monat) throws Exception {
        List<String> monatList = Arrays.asList(Zeit.monate);
        if (!monatList.contains(monat)) {
            throw new Exception("ungueltiger Wert fuer Monat: " + '\"' + monat + '\"');
        }
        return monatList.indexOf(monat) + 1; // +1 Da index bei 0 beginnt.
    }
}