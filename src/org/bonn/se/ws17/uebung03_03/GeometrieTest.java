package org.bonn.se.ws17.uebung03_03;

import org.bonn.se.ws17.uebung03_04.Geometrie;

class GeometrieTest {
    public static boolean test() {
        return (GeometrieTest.testProgramm(0, 0, 0, 0)
                & GeometrieTest.testProgramm(1, 1, 1, 4)
                & GeometrieTest.testProgramm(-1, 1, -1, 0)
                & GeometrieTest.testProgramm(1, -1, -1, 0)
                & GeometrieTest.testProgramm(-10, 10, -100, 0));
    }

    public static boolean testProgramm(int a, int b, int erwF, int erwU) {
        return (erwF == Geometrie.flaecheREck(a, b) && erwU == Geometrie.umfangREck(a, b));
    }
}