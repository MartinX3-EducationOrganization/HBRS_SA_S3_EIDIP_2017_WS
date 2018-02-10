package org.bonn.se.ws17.uebung05_09.dialog;

import org.bonn.se.ws17.uebung05_09.finanzen.Umrechnung;

import java.util.Scanner;

public class UmrechnungUser {
    public static void dialog() {
        String output = "";
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double value = sc.nextDouble();
            String cur = sc.next();
            if (cur.equals("Euro")) {
                value = Umrechnung.zuDollar(value);
                output += value + " Euro" + "\n";
            } else if (cur.equals("Dollar")) {
                value = Umrechnung.zuEuro(value);
                output += value + " Dollar" + "\n";
            }
        }
        System.out.print(output);
    }
}
