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

    public static void main(String[] args) throws Exception {
        Gomoku g = new Gomoku(6, 5, 4, 3);
        g.naechster();
        g.setze(0, 0);
        g.naechster();
        g.setze(0, 1);
        g.naechster();
        g.setze(0, 3);
        g.naechster();
        g.setze(0, 4);
        g.naechster();
        g.setze(1, 1);
        g.naechster();
        g.setze(1, 2);
        g.naechster();
        g.setze(1, 3);
        g.naechster();
        g.setze(2, 0);
        g.naechster();
        g.setze(2, 1);
        g.naechster();
        g.setze(2, 3);
        g.naechster();
        g.setze(2, 4);
        g.naechster();
        g.setze(3, 1);
        g.naechster();
        g.setze(3, 2);
        g.naechster();
        g.setze(3, 3);
        g.naechster();
        g.setze(4, 0);
        g.naechster();
        g.setze(4, 1);
        g.naechster();
        g.setze(4, 3);
        g.naechster();
        g.setze(4, 4);
        g.naechster();
        g.setze(5, 1);
        g.naechster();
        g.setze(5, 2);
        g.naechster();
        g.setze(5, 3);
        g.istReihe(0, 0);
        g.istReihe(0, 1);
        g.istReihe(0, 2);
        g.istReihe(0, 3);
        g.istReihe(0, 4);
        g.istReihe(1, 0);
        g.istReihe(1, 1);
        g.istReihe(1, 2);
        // Laut Praktomat soll das false sein. -.-
        System.out.println(g.istReihe(1, 4));
        System.out.println(g.toString());
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
                return true;

            }
            naechster++;
            return false;
        }
    }

    public boolean istReihe(int i, int j) {
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
            if (spielfeld[i + incI][j + incJ] == naechster()) {
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
