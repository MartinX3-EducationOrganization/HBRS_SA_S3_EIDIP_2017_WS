package org.bonn.se.ws17.uebung03_04;


public class Geometrie {
    public static int flaecheREck(int laenge, int breite) {
        return laenge * breite;
    }

    public static int umfangREck(int laenge, int breite) {
        return 2 * (laenge + breite);
    }
}
