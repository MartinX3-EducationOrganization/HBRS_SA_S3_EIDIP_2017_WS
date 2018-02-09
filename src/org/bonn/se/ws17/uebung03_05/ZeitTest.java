package org.bonn.se.ws17.uebung03_05;

import org.bonn.se.ws17.uebung03_06.Zeit;

public class ZeitTest {
    public static boolean test() {
        return (!Zeit.istSChaltjahr(1582) &&    // before 1583 and no leap-year
                Zeit.istSChaltjahr(8) &&        // before 1583 and / 4
                Zeit.istSChaltjahr(400) &&      //
                Zeit.istSChaltjahr(100) &&      //
                Zeit.istSChaltjahr(1996) &&     // after 1583 and / 4
                !Zeit.istSChaltjahr(1600) &&    // after 1583 / 4  and no leap-year
                Zeit.istSChaltjahr(2000) &&     // after 1583 / 4 and / 400
                !Zeit.istSChaltjahr(1977));     // after 1583 no leap-year
    }
}
