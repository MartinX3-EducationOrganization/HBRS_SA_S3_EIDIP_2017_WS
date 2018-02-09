package org.bonn.se.ws17.uebung05_02;

import java.util.Scanner;

public class Leser {
    public static String vorNach() {

        Scanner sc = new Scanner(System.in);
        String text = "";
        while (sc.hasNext()) {
            String vorNach = sc.next();
            String z = sc.next();
            String in = sc.next();
            String zf = sc.next();
            
            if (zf.contains(z)) {
                switch (vorNach) {
                    case "vor":
                        text = zf.substring(0, zf.lastIndexOf(z));
                        break;
                    case "nach":
                        text = zf.substring(zf.indexOf(z) + 1);
                        break;
                    default:
                        text = (String.format("Erste Eingabe: %s nicht erkannt", vorNach));
                        break;
                }
            } else {
                if (vorNach.equals("vor")) {
                    text = "";
                } else if (vorNach.equals("nach")) {
                    text = zf;
                }
            }
        }
        sc.close();
        return text;
    }
}