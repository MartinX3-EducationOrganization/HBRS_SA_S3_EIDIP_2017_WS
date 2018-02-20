package org.bonn.se.ws17.uebung12_05;

import org.bonn.se.ws17.uebung12_04.FigurPerMitte;
import org.bonn.se.ws17.uebung12_04.Punkt;

public class KreisPerMitteRadius extends FigurPerMitte {
    private final double eps = 0.000001;
    private final double radius;

    public KreisPerMitteRadius(Punkt mitte, double radius) {
        super(mitte);
        this.radius = radius;
    }

    public KreisPerMitteRadius(KreisPerMitteRadius kreis) {
        super(kreis.mitte());
        radius = kreis.radius;
    }

    public double radius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof KreisPerMitteRadius) {
            return ((Math.abs(((KreisPerMitteRadius) o).radius() - radius) < eps && (Math.abs(((KreisPerMitteRadius) o).mitte().abstand(mitte())) < eps)));
        }
        return false;
    }

    @Override
    public double durchmesser() {
        return 2 * radius;
    }

    @Override
    public double flaeche() {
        return Math.PI * radius * radius;
    }

    @Override
    public double umfang() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean istEnthalten(Punkt p) {
        return p.abstand(mitte()) <= radius;
    }

    @Override
    // toString gibt die Darstellung des Kreises im Format [mitte,radius] zurück, worin mitte für
    //die Darstellung der Mitte im Format von Punkt steht und radius für den Zahlwert des Radius.
    public String toString() {
        return String.format("[%s," + radius + "]", mitte());
    }
}