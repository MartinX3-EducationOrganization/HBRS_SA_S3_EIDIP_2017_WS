package org.bonn.se.ws17.uebung08_03;

public class Zahlen {
    public static int summeRek(int a, int b) {

        return Zahlen.summeRek(a, b, 0);
    }

    // a + b = ?
    public static int summeRek(int a, int b, int c) {
        if (a > 0) {
            a--;
            c++;
            return Zahlen.summeRek(a, b, c);
        } else if (a < 0) {
            a++;
            c--;
            return Zahlen.summeRek(a, b, c);
        }
        // Sobald a 0 kommen wir zu b.
        else if (b > 0) {
            b--;
            c++;
            return Zahlen.summeRek(a, b, c);
        } else if (b < 0) {
            b++;
            c--;
            return Zahlen.summeRek(a, b, c);
        }
        return c;
    }

    // a - b = ?
    public static int differenzRek(int a, int b) {
        return Zahlen.differenzRek(a, b, 0);
    }

    public static int differenzRek(int a, int b, int c) {
        if (a > 0) {
            a--;
            c++;
            return Zahlen.differenzRek(a, b, c);
        } else if (a < 0) {
            a++;
            c--;
            return Zahlen.differenzRek(a, b, c);
        } else if (b > 0) {
            b--;
            c--;
            return Zahlen.differenzRek(a, b, c);
        } else if (b < 0) {
            b++;
            c++;
            return Zahlen.differenzRek(a, b, c);
        }
        return c;   //a = 0 & b = 0
    }

    // a * b = ?
    public static int produktRek(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else if (a < 0 && b > 0) {
            return -Zahlen.produktRek(-a, b, 0, -a);
        } else if (a > 0 && b < 0) {
            return -Zahlen.produktRek(a, -b, 0, a);
        } else if (a < 0 && b < 0) {
            return Zahlen.produktRek(-a, -b, 0, -a);
        } else {
            return Zahlen.produktRek(a, b, 0, a);
        }
    }

    public static int produktRek(int a, int b, int c, int d) {
        if (a > 0) {
            c++;
            a--;
            return Zahlen.produktRek(a, b, c, d);
        } else if (b > 1) {
            b--;
            a = d;
            return Zahlen.produktRek(a, b, c, d);
        }

        return c;
    }

    public static int quotientRek(int a, int b) throws Exception {
        if (a < 0 || b <= 0) {
            throw new Exception("Es soll a >= 0 und b > 0 gelten!");
        } else if (b > a) {
            return 0;
        }
        return Zahlen.quotientRek(a, b, b, 0);
    }

    public static int quotientRek(int a, int b, int c, int d) {
        if (a >= c) {
            c = Zahlen.summeRek(c, b);
            d++;
            return Zahlen.quotientRek(a, b, c, d);
        } else {
            return d;
        }
    }

    public static int moduloRek(int a, int b) throws Exception {
        if (a < 0 || b <= 0) {
            throw new Exception("Es soll a >= 0 und b > 0 gelten!");
        }
        return Zahlen.differenzRek(a, (Zahlen.produktRek(b, Zahlen.quotientRek(a, b))));
    }

    // b^e = ?  3^1 + 3 ^2 + 3 ^ 3
    public static int potenzRek(int b, int e) throws Exception {
        if (e < 0) {
            throw new Exception("E >= 0 !!!!");
        } else if (e == 0) {
            return 1;
        }
        return Zahlen.potenzRek(b, e, b);
    }

    public static int potenzRek(int b, int e, int c) {
        if (e > 1) {
            c = Zahlen.produktRek(b, c);
            e--;
            return Zahlen.potenzRek(b, e, c);
        }
        return c;
    }
}