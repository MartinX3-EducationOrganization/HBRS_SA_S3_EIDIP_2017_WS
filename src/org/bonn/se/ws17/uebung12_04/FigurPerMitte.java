package org.bonn.se.ws17.uebung12_04;

public abstract class FigurPerMitte extends Figur {
    private Punkt mittelpunkt;

    public FigurPerMitte(Punkt mitte) {
        Punkt p = new Punkt(mitte);
        mittelpunkt = p;
    }

    public FigurPerMitte(FigurPerMitte figurMitte) {
        mittelpunkt = figurMitte.mittelpunkt;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public Punkt mitte() {
        return mittelpunkt;
    }

    @Override
    public abstract double durchmesser();

    @Override
    public abstract double flaeche();

    @Override
    public abstract double umfang();

    @Override
    public abstract boolean istEnthalten(Punkt p);

    @Override
    public FigurPerMitte verschiebe(double dx, double dy) {
        Punkt newMitte = new Punkt(mittelpunkt.x() + dx, mittelpunkt.y() + dy);
        mittelpunkt = newMitte;
        return this;
    }

    @Override
    public abstract String toString();
}