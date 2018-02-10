package org.bonn.se.ws17.uebung06_06;


public class Rechteck {
    //Wert der Ränder
    private double xl;
    private double xr;
    private double yu;
    private double yo;

    public Rechteck(double xl, double xr, double yu, double yo) {
        this.xl = xl;
        this.xr = xr;
        this.yu = yu;
        this.yo = yo;
    }

    public Rechteck(Punkt p1, Punkt p2) {
        xl = Math.min(p1.x(), p2.x());
        xr = Math.max(p1.x(), p2.x());
        yu = Math.min(p1.y(), p2.y());
        yo = Math.max(p1.y(), p2.y());
    }

    public boolean equals(Rechteck o) {
        return (o.xl == xl && o.xr == xr && o.yu == yu && o.yo == yo);
    }

    public double laenge() {
        return Math.abs(xl - xr);
    }

    public double breite() {
        return Math.abs(yo - yu);
    }

    public double flaeche() {
        return laenge() * breite();
    }

    public double umfang() {
        return 2 * (laenge() + breite());
    }

    public Punkt ecke(boolean links, boolean unten) {
        double x;
        double y;
        if (links) {
            x = xl;
        } else {
            x = xr;
        }
        if (unten) {
            y = yu;
        } else {
            y = yo;
        }
        return new Punkt(x, y);
    }

    public boolean istEnthalten(Punkt p) {
        return (p.x() >= xl && p.x() <= xr && p.y() >= yu && p.y() <= yo);
    }

    public boolean istEnthalten(Rechteck o) {
        return (o.xl >= xl && o.xr <= xr && o.yu >= yu && o.yo <= yo);
    }

    public Rechteck huelle(Punkt p) {
        return new Rechteck(Math.min(xl, p.x()), Math.max(xr, p.x()), Math.min(yu, p.y()), Math.max(yo, p.y()));
    }

    public Rechteck huelle(Rechteck o) {
        return new Rechteck(Math.min(xl, o.xl), Math.max(xr, o.xr), Math.min(yu, o.yu), Math.max(yo, o.yo));
    }

    public Rechteck schnitt(Rechteck o) {
        Rechteck r = new Rechteck(xl, xr, yu, yo);
        if (o.xr < xl || o.xl > xr || o.yu > yo || o.yo < yu) {
            return null;
        } else {
            // Falls das überg. Rechteck innerhalb des Instanzierte Recheckes ist
            if (istEnthalten(o)) {
                return o;
            }
            // Falls das überg. Rechteck das instanziertes übeerlappt oder schneidet.

            if (o.xr > xl && o.xr < xr) {
                r.xr = o.xr;
            }
            if (o.xl < xr && o.xl > xl) {
                r.xl = o.xl;
            }
            if (o.yu < yo && o.yu > yu) {
                r.yu = o.yu;
            }
            if (o.yo > yu && o.yo < yo) {
                r.yo = o.yo;
            }

        }
        return r;
    }

    @Override
    public String toString() {
        String lup = "(" + xl + "," + yu + ")";
        String rop = "(" + xr + "," + yo + ")";
        return "[" + lup + "," + rop + "]";
    }
}
