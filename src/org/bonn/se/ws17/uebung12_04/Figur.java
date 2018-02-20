package org.bonn.se.ws17.uebung12_04;

public abstract class Figur {

    @Override
    public abstract boolean equals(Object o);

    public abstract Punkt mitte();

    public abstract double durchmesser();

    public abstract double flaeche();

    public abstract double umfang();

    public abstract boolean istEnthalten(Punkt p);

    public abstract Figur verschiebe(double dx, double dy);

    @Override
    public abstract String toString();

}