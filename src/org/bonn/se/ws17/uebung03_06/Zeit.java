package org.bonn.se.ws17.uebung03_06;

public class Zeit {
    public static boolean istSChaltjahr(int year) {
        if (year < 1583) {
            return (year % 4 == 0);
        } else {
            return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
        }
    }
}
