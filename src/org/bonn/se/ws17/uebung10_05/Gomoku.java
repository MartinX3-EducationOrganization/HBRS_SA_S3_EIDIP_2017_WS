package org.bonn.se.ws17.uebung10_05;

public class Gomoku {
    private final int z;
    private final int s;
    private final int n;
    private final int p;
    private final int[][] spielfeld;
    //    die Zahl z der Zeilen des Spielfelds
    //    die Zahl s der Spalten des Spielfelds
    //    die Zahl n der Länge einer Reihe, mit der man gewinnt
    //    die Zahl p der Spieler
    private int naechster = 0;

    public Gomoku(int z, int s, int n, int p) {
        this.z = z;
        this.s = s;
        this.n = n;
        this.p = p;
        spielfeld = new int[z][s];
    }

    public int naechster() {
        if (naechster + 1 > p) {
            naechster = 0;
        }
        return naechster + 1;
    }

    public boolean setze(int i, int j) throws Exception {
        if (spielfeld[i][j] != 0) {
            throw new Exception();
        } else {
            spielfeld[i][j] = naechster();
            if (istReihe(i, j)) {
                naechster++;
                return true;
            } else {
                naechster++;
                return false;
            }
        }
    }


    public boolean istReihe(int i, int j) {
        // Fall der Punkt(i,j) ungleich dem SpielerStein ist.
        if (spielfeld[i][j] == 0) {
            return false;
        }
        // Horizontal
        if (((zaehle(i, j, 0, 1, 0) + (zaehle(i, j, 0, -1, 0)) == n - 1))) {
            return true;
            // Vertikal
        } else if (((zaehle(i, j, 1, 0, 0) + (zaehle(i, j, -1, 0, 0)) == n - 1))) {
            return true;
            //Diagonaal \
        } else if (((zaehle(i, j, -1, -1, 0) + (zaehle(i, j, 1, 1, 0)) == n - 1))) {
            return true;
            //Diagonal /
        } else if (((zaehle(i, j, 1, -1, 0) + (zaehle(i, j, -1, 1, 0)) == n - 1))) {
            return true;
        }
        return false;
    }

    private int zaehle(int i, int j, int incI, int incJ, int count) {
        int a = i + incI;
        int b = j + incJ;
        if (a >= 0 && a < z && b >= 0 && b < s) {
            if (spielfeld[a][b] == spielfeld[i][j]) {
                return zaehle(i + incI, j + incJ, incI, incJ, count + 1);
            }
            return count;
        } else {
            return count;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if (spielfeld[i][j] == 0) {
                    s += "_";
                } else {
                    s += spielfeld[i][j];
                }
            }
            s += "\n";
        }
        return s;
    }
}