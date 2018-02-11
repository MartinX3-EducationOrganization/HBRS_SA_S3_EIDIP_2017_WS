package org.bonn.se.ws17.uebung08_01;

public class Zahlen {

    public static int summeLoop(int a, int b) {
        int counter = 0;

        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        } else if (a < 0 && b < 0) {
            return -(Zahlen.summeLoop(-a, -b));
        } else if (a < 0 && b > 0) {
            for (int i = 0; a < i; i--) {
                counter--;
            }
            for (int j = 0; j < b; j++) {
                counter++;
            }
            return counter;
        } else if (b < 0 && a > 0) {
            return -(Zahlen.summeLoop(-a, -b));
        }

        for (int i = 0; i < a; i++) {
            counter++;
        }
        for (int j = 0; j < b; j++) {
            counter++;
        }
        return counter;
    }

    public static int differenzLoop(int a, int b) {
        if (a == 0) {
            return -b;
        } else if (b == 0) {
            return a;
        } else if (a > 0 && b > 0) {
            for (int i = 0; i < b; i++) {
                a--;
            }
            return a;
        } else if (a > 0 && b < 0) {
            return Zahlen.summeLoop(a, -b);
        } else if (a < 0 && b > 0) {
            return -Zahlen.summeLoop(-a, b);
        } else if (a < 0 && b < 0) {
            return -Zahlen.differenzLoop(-a, -b);
        }


        return 0;
    }

    public static int produktLoop(int a, int b) {
        int counter = 0;
        if (a == 0 || b == 0) {
            return 0;
        } else if (a > 0 && b > 0) {
            for (int i = 0; i < b; i++) {
                for (int j = 0; j < a; j++) {
                    counter++;
                }
            }
        } else if (a < 0 && b < 0) {
            for (int i = 0; i > b; i--) {
                for (int j = 0; j > a; j--) {
                    counter++;
                }
            }
        } else {
            if (b < 0) {
                return -(Zahlen.produktLoop(a, -b));
            } else {
                return -(Zahlen.produktLoop(-a, b));
            }
        }
        return counter;
    }

    public static int quotientLoop(int a, int b) throws Exception {

        int counter = 0;
        int c = b;
        if (a < 0 || b <= 0) {
            throw new Exception("Es soll a >= 0 und b > 0 gelten!");
        }
        if (b > a) {
            return 0;
        }
        for (int i = 0; c <= a; i++) {
            c = Zahlen.summeLoop(c, b);
            counter++;
        }

        return counter;
    }
    
    public static int moduloLoop(int a, int b) {
        int modulo = 0;
        try {
            modulo = Zahlen.differenzLoop(a, (Zahlen.produktLoop(b, Zahlen.quotientLoop(a, b))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modulo;
    }

    public static int potenzLoop(int b, int e) throws Exception {

        if (e < 0) {
            throw new Exception("Es muss e => 0 gelten!");
        }

        int rechner = b;
        if (e == 0) {
            return 1;
        }
        for (int i = 1; i < e; i++) {
            rechner = Zahlen.produktLoop(rechner, b);
        }
        return rechner;
    }
}