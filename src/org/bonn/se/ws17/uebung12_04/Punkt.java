//package org.bonn.se.ws17.uebung12_04;
//
//public class Punkt {
//    private double x; // = 0; (implizite Init.)
//    private double y; // = 0; (implizite Init.)
//
//    public Punkt() {
//    }
//
//    public Punkt(double x, double y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public Punkt(Punkt p) {
//        this(p.x, p.y);
//    }
//
//    public double x() {
//        return x;
//    }
//
//    public double y() {
//        return y;
//    }
//
//    public boolean equals(Punkt p) {
//        return Zahlen.equals(x, p.x) && Zahlen.equals(y, p.y);
//    }
//
//    public Punkt verschiebe(double dx, double dy) {
//        x += dx;
//        y += dy;
//        return this;
//    }
//
//    public double abstand(Punkt p) {
//        double dx = x - p.x;
//        double dy = y - p.y;
//        return Math.sqrt(dx * dx + dy * dy);
//    }
//
//    @Override
//    public String toString() {
//        return "(" + x + "," + y + ")";
//    }
//}
