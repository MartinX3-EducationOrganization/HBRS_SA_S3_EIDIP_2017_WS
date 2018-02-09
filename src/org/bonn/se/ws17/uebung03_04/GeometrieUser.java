package org.bonn.se.ws17.uebung03_04;


import java.util.Scanner;

public class GeometrieUser {
    public static void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            String auswahl = sc.next();

            if (auswahl.equals("Flaeche")) {
                System.out.println(Geometrie.flaecheREck(a, b));
            } else if (auswahl.equals("Umfang")) {
                System.out.println(Geometrie.umfangREck(a, b));
            } else {
                System.out.println("Falsche Eingabe!");
            }
        }
        sc.close();
    }
}