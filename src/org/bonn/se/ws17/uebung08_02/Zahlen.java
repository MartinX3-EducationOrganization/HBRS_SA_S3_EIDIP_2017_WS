package org.bonn.se.ws17.uebung08_02;

public class Zahlen {
    private static final double eps = 0.00000001;

    public static double pi1(int k) {
        boolean vorzeichen = true;
        double rechenmaschine = 0.0;
        for (int i = 0; i < k; i++) {
            double nenner = ((2 * i) + 1);
            double bruch = 1 / nenner;
            if (vorzeichen) {
                rechenmaschine = rechenmaschine + bruch;
            } else {
                rechenmaschine = rechenmaschine - bruch;
            }
            vorzeichen = !vorzeichen;

        }
        return (rechenmaschine * 4.0);  // Da es gegen Pi/4 konvergiert.
    }

    // Falls kein eps Wert übertragen wird nehmen wir den aus Aufgabe.(Überladung)
    public static double pi2() {
        return Zahlen.pi2(Zahlen.eps);
    }

    public static double pi2(double eps) {
        boolean vorzeichen = true;
        double rechenmaschine = 0.0;
        double bruch;
        int i = 0;
        do {
            double nenner = ((2 * i) + 1);
            bruch = 1 / nenner;

            if (Math.abs(bruch) <= eps) {
                return rechenmaschine * 4.0;
            }
            if (vorzeichen) {
                rechenmaschine = rechenmaschine + bruch;
            } else {
                rechenmaschine = rechenmaschine - bruch;
            }
            vorzeichen = !vorzeichen;
            i++;
        }
        while (Math.abs(bruch) >= eps); //Solange der letzte Wert nicht kleiner gleich EPS ist mach weiter.
        return (rechenmaschine * 4.0);  //
    }

    public static double pi3() {
        return Zahlen.pi3(Zahlen.eps);
    }

    public static double pi3(double eps) {
        double differenzuPi;
        boolean vorzeichen = true;
        double rechenmaschine = 0.0;
        double summand;
        int i = 0;
        do {
            double nenner = ((2 * i) + 1);
            summand = 1 / nenner;

            if (vorzeichen) {
                rechenmaschine = rechenmaschine + summand;
            } else {
                rechenmaschine = rechenmaschine - summand;
            }
            vorzeichen = !vorzeichen;
            i++;
            double temp = (rechenmaschine * 4.0);
            differenzuPi = Math.PI - temp;
        }
        while (Math.abs(differenzuPi) > eps);
        return 4.0 * rechenmaschine;
    }
}