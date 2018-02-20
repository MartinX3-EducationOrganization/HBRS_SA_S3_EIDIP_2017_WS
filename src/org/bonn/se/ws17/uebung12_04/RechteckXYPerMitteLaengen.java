package org.bonn.se.ws17.uebung12_04;

public class RechteckXYPerMitteLaengen extends FigurPerMitte {
    private final double eps = 0.0001;
    private final double x;
    private final double y;

    public RechteckXYPerMitteLaengen(Punkt mitte, double breite, double laenge) {
        super(mitte);
        x = breite;
        y = laenge;
    }

    public RechteckXYPerMitteLaengen(RechteckXYPerMitteLaengen rechteck) {
        super(rechteck);
        x = rechteck.x;
        y = rechteck.y;
    }

    public double laenge() {
        return x;
    }

    public double breite() {
        return y;
    }

    public Punkt ecke(boolean istLinks, boolean istUnten) {
        // Links Unten = von mitte hälfte breite nach links und hälfte laenge nach unteen
        if (istLinks) {
            if (istUnten) {
                return new Punkt(mitte().x() - (0.5 * x), mitte().y() - (0.5 * y));
            } else {
                return new Punkt(mitte().x() - (0.5 * x), mitte().y() + (0.5 * y));
            }
        } else {
            if (istUnten) {
                return new Punkt(mitte().x() + (0.5 * x), mitte().y() - (0.5 * y));
            } else {
                return new Punkt(mitte().x() + (0.5 * x), mitte().y() + (0.5 * y));
            }
        }
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof RechteckXYPerMitteLaengen) {
            if (Math.abs(((RechteckXYPerMitteLaengen) o).mitte().abstand(mitte())) < eps && (Math.abs(((RechteckXYPerMitteLaengen) o).x - x) < eps) && (Math.abs(((RechteckXYPerMitteLaengen) o).y - y) < eps)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double durchmesser() {
        return Math.sqrt((x * x) + (y * y));
    }

    @Override
    public double flaeche() {
        return x * y;
    }

    @Override
    public double umfang() {
        return 2 * (x + y);
    }

    @Override
    public boolean istEnthalten(Punkt p) {
        double a = mitte().x() + (0.5 * x);
        double b = mitte().x() - (0.5 * x);
        double c = mitte().y() + (0.5 * y);
        double d = mitte().y() - (0.5 * y);
        if (p.x() > a || p.x() < b) {
            return false;
        }
        if (p.y() > c || p.y() < d) {
            return false;
        }
        return true;
    }

    @Override
    //[lup,rop]"
    public String toString() {
        return "[" + ecke(true, true) + "," + ecke(false, false) + "]";
    }
}