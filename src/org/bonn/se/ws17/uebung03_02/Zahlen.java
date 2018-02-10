package org.bonn.se.ws17.uebung03_02;


public class Zahlen {
    public static void vielfache(int a, int n) {
        int x = 1;
        String ausgabe = "";
        while (x <= n) {
            ausgabe += "" + (a * x) + " ";
            x++;
        }
        System.out.println(ausgabe);
    }

    public static void einmaleins(int n) {
        int w = 0;
        while (n != w) {
            w++;
            Zahlen.vielfache(w, n);
        }
    }

    public static void main(String[] args) {
        Zahlen.einmaleins(5);
    }
}
