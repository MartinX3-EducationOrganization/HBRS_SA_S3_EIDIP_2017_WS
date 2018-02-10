package org.bonn.se.ws17.uebung06_05;

import org.bonn.se.ws17.uebung06_04.Zahlen;

public class Rational {

    private int dividend;
    private int divisor;

    //  Standard Konstruktor: Wird kein Argument gegeben, soll der Bruch den Wert 0 darstellen
    public Rational() {
        dividend = 0;
        divisor = 1;
    }

    // Für eine ganze Zahl als Argument soll der Bruch den Wert dieser Zahl darstellen.
    public Rational(int a) {
        dividend = a;
        divisor = 1;
    }


    public Rational(int dividend, int divisor) {
        //Both negative -> positive
        if (dividend < 0 && divisor < 0) {
            dividend = dividend * -1;
            divisor = divisor * -1;
            //divisor negative -> negative to dividend (divisor has to be positive)
        } else if (divisor < 0 && dividend > 0) {
            divisor = divisor * (-1);
            dividend = dividend * (-1);
        }
        this.dividend = dividend / (Zahlen.ggT(dividend, divisor));
        this.divisor = divisor / (Zahlen.ggT(dividend, divisor));
    }

    public int zaehler() {
        return dividend;
    }

    public int nenner() {
        return divisor;
    }

    public boolean equals(Rational o) {
        return (o.dividend == dividend & o.divisor == divisor);
    }

    public boolean istKleiner(Rational o) {
        return (o.dividend / o.divisor) > (dividend / divisor);
    }

    public Rational abs() {
        Rational o = new Rational(dividend, divisor);
        if (dividend < 0) {
            o.dividend = dividend * (-1);
            o.divisor = divisor;
        } else {
            o.dividend = dividend;
            o.divisor = divisor;
        }
        return o;

    }

    public Rational reziprok() {
        if (dividend == 0) {
            return null;
        } else {
            return new Rational(divisor, dividend);
        }
    }

    public Rational add(Rational o) {
        return new Rational(dividend * o.divisor + o.dividend * divisor, divisor * o.divisor);
    }

    public Rational sub(Rational o) {
        return new Rational(dividend * o.divisor - o.dividend * divisor, divisor * o.divisor);
    }

    public Rational mul(Rational o) {
        return new Rational(dividend * o.dividend, divisor * o.divisor);
    }

    public Rational div(Rational o) {
        return new Rational(dividend * o.divisor, divisor * o.dividend);
    }

    @Override
    public String toString() {
        return "" + dividend + "/" + divisor;
    }
}