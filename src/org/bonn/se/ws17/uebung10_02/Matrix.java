package org.bonn.se.ws17.uebung10_02;


import java.util.Scanner;

public class Matrix {
    private final double[][] tabelle;

    public Matrix(int z, int s) {
        tabelle = new double[z][s];
    }

    public Matrix(int n) {
        this(n, n);
    }

    public Matrix(Matrix o) {
        tabelle = new double[o.zeilen()][o.spalten()];
        for (int i = 0; i < o.zeilen(); i++) {
            for (int j = 0; j < o.spalten(); j++) {
                tabelle[i][j] = o.get(i, j);
            }
        }
    }

    public int zeilen() {
        return tabelle.length;
    }

    public int spalten() {
        return tabelle[0].length;
    }

    public double get(int z, int s) {
        return tabelle[z][s];
    }

    public Matrix set(int z, int s, double e) {
        tabelle[z][s] = e;
        return this;
    }

    public Matrix setAll(double e) {
        for (int i = 0; i < tabelle.length; i++) {
            for (int j = 0; j < tabelle[j].length; j++) {
                tabelle[i][j] = e;
            }
        }
        return this;
    }

    public Matrix setZeile(int z, double[] e) {
        for (int j = 0; j < tabelle[0].length; j++) {
            tabelle[z][j] = e[j];
        }
        return this;
    }

    public Matrix setSpalte(int s, double[] e) {
        for (int i = 0; i < tabelle.length; i++) {
            tabelle[i][s] = e[i];
        }
        return this;
    }

    // Ohne Zahlenklasse
    public boolean equals(Matrix o) {
        // Gleich Groß
        if (o.spalten() == spalten() && o.zeilen() == zeilen()) {
            for (int i = 0; i < tabelle.length; i++) {
                for (int j = 0; j < tabelle[0].length; j++) {
                    if (!(Math.abs(o.tabelle[i][j] - tabelle[i][j]) < 0.0000001)) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String ausgabe = "";
        for (int i = 0; i < tabelle.length; i++) {
            ausgabe += "(";
            for (int k = 0; k < tabelle[0].length; k++) {
                ausgabe += " " + tabelle[i][k];
            }
            ausgabe += " )\n";
        }

        return ausgabe;
    }

    public Matrix eingabe(Scanner sc) {
        int z = 0;
        int s = 0;

        while (sc.hasNext()) {
            if (sc.next().equals("(")) {
                while (sc.hasNext()) {
                    if (sc.hasNextDouble()) {
                        tabelle[z][s] = sc.nextDouble();
                        s++;
                    } else if (sc.next().equals(")")) {
                        z++;
                        s = 0;
                        break;
                    }
                }
            }

        }
        return this;
    }
}