package org.bonn.se.ws17.uebung08_05;

public class Zahlen {
    // b = potenz (a^b)
    public static int potenzLoop(int a, int b) {
        int c = a;
        if (b == 0) {
            return 1;
        }
        while (b > 1) {
            if (b % 2 == 0) {

                a *= a;
                b /= 2;

            } else if (b % 2 != 0) {
                a *= a * c;
                b /= 2;
            }
        }
        return a;
    }

    public static int potenzRek(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return Zahlen.potenzR(a, b);
    }

    private static int potenzR(int a, int b) {
        if (b == 1) {
            return a;
        }
        if (b % 2 == 0) {
            return Zahlen.potenzR(a * a, b / 2);
        } else {
            return Zahlen.potenzR(a * a, b / 2) * a;
        }
    }

    public static void main(String[] args) {
        System.out.println(Zahlen.potenzLoop(4, 2));
    }
}