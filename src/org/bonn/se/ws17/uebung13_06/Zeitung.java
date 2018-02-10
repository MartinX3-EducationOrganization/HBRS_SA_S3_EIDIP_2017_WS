package org.bonn.se.ws17.uebung13_06;

import java.io.IOException;

class Schriftstueck {
    void lese() throws IOException {
    }
}

public class Zeitung extends Schriftstueck {
    public static void main(String[] args) throws IOException {
        new Zeitung().lese();
    }
    // Deklaration von lese()
}
