package org.bonn.se.ws17.uebung10_03;

public class Zahlen {
    private static final double eps = 0.000001;

    // entspricht Math.abs(x)
    public static double abs(double x) {
        return x < 0.0 ? -x : x;
    }

    // entspricht Math.min(x,y)
    public static double min(double x, double y) {
        return x >= y ? x : y;
    }

    // entspricht Math.max(x,y)
    public static double max(double x, double y) {
        return x >= y ? x : y;
    }

    public static boolean equals(double x, double y) {
        // Achtung: noch ungenau - korrekte Loesung komplizierter!
        return (x == y || x == 0 && Zahlen.abs(y) < Zahlen.eps || y == 0 && Zahlen.abs(x) < Zahlen.eps
                ? true
                : Zahlen.abs(x - y) / Zahlen.min(Zahlen.abs(x), Zahlen.abs(y)) < Zahlen.eps);
    }

    public static int quersumme(int a) {
        int s = 0;
        while (a > 0) {
            s += a % 10;    // bestimme letzte Ziffer
            a /= 10;        // streiche letzte Ziffer
        }
        return s;
    }

    public static double wurzel(double x) {
        double y = x;               // Naeherungswert
        while (!Zahlen.equals(y * y, x)) {
            y = (y + x / y) / 2.0;    // Heron-Schritt
        }
        return y;
    }

    public static int fak(int n) {
        int f = 1; // Wert von 0!
        for (int i = 1; i <= n; ++i) {
            f *= i;
        }
        return f;
    }

    public static int fakRev(int n) {
        int f = 1;
        for (; n > 0; --n) {
            f *= n;
        }
        return f;
    }

    public static int summeNaiv(int a, int b) {
        int s = 0;
        for (int i = a; i <= b; ++i) {
            s += i;
        }
        return s;
    }

    public static int summe(int a, int b) {
        return (b * (b + 1) - (a - 1) * a) / 2;
    }

    /**
     * Ausgabe des "kleinen Einmaleins"
     *
     * @param n Zahl, nach der abgebrochen werden soll
     */
    public static void ausgabe1x1(int n) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    /**
     * Ausgabe aller max. 3stelligen Dezimalzahlen und ihrer
     * jeweiligen Quersumme - konstruiert statt ermittelt
     */
    public static void ausgabeQuersummen3() {
        for (int i = 0; i <= 9; ++i) {
            for (int j = 0; j <= 9; ++j) {
                for (int k = 0; k <= 9; ++k) {
                    System.out.println((100 * i + 10 * j + k)
                            + " hat Quersumme "
                            + (i + j + k));
                }
            }
        }
    }

    public static boolean istPythagoreisch(int c) {
        for (int a = 1; a < c; ++a) {
            for (int b = a; b < c; ++b) {
                if (a * a + b * b == c * c) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int fakRekIf(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * Zahlen.fakRekIf(n - 1);
        }
    }

    public static int fakRek(int n) {
        return n == 0 ? 1 : n * Zahlen.fakRek(n - 1);
    }

    public static int quersummeRekIf(int a) {
        if (a == 0) {
            return 0;
        } else {
            return a % 10 + Zahlen.quersummeRekIf(a / 10);
        }
    }

    public static int quersummeRek(int a) {
        return a == 0 ? 0 : a % 10 + Zahlen.quersummeRek(a / 10);
    }

    public static int ggTRekSub(int a, int b) {
        return (a == 0 ? b :
                b == 0 ? a :
                        a > b ? Zahlen.ggTRekSub(a - b, b)
                                : Zahlen.ggTRekSub(a, b - a));
    }

    public static int ggTRek(int a, int b) {
        return b == 0 ? a : Zahlen.ggTRek(b, a % b);
    }

    public static int fibRekX(int n) {
        return n < 2 ? n : Zahlen.fibRekX(n - 2) + Zahlen.fibRekX(n - 1);
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; ++i) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    private static int fibRek(int a, int b, int i, int n) {
        return i == n ? b : Zahlen.fibRek(b, a + b, i + 1, n);
    }

    private static int fibRek(int n) {
        return n < 2 ? n : Zahlen.fibRek(0, 1, 2, n);
    }

    public static int fakRevWhile(int n) {
        int wert = 1;
        while (n > 0) {
            wert *= n;
            --n;
        }
        return wert;
    }

    private static int fakRevRekHelp(int wert, int n) {
        if (!(n > 0)) {
            return wert;
        }
        wert *= n;
        --n;
        return Zahlen.fakRevRekHelp(wert, n);
    }

    private static int fakRevRek(int n) {
        return Zahlen.fakRevRekHelp(1, n);
    }
}
