/*
package org.bonn.se.ws17.uebung11_03;

public class Job {
    public static void zweck() {
        System.out.println("bringt Geld");
    }

    public void start() {
        System.out.println("los!");
    }

    public void stop() {
        System.out.println("fertig!");
    }

    public void erledigen() {
        start();
        stop();
    }
}

public class Programmieraufgabe extends Job {
    public static void zweck() {
        System.out.println("rettet die Welt");
    }

    @Override
    public void start() {
        System.out.println("Kaffee holen!");
    }

    @Override
    public void stop() {
        System.out.println("Loesung in den Praktomat laden!");
    }
}

public class Arbeiten {
    public static void main(String[] args) {
        Job job = new Programmieraufgabe();
        job.erledigen();
        job.zweck();
    }
}

Lösung:

    Ausgabe:

Kaffee holen!
Loesung in den Praktomat laden!
bringt Geld

Erklärung:

In der Classe Arbeiten wird die Main aufgerufen.
Hier wir ein neues Job-Objekt vom Typ Programmieraufgabe iniziert.
job.erldigen(): Programmieraufgabe hat keine (Instanz-) Methode mit erledigen. Aber die Klasse Job.
                In der Klasse Job wird erledigen() aufgerufen, das wiederrum start() und stop() aufruft,
                aber aus der (Spez./Kind-)Klasse Programmieraufgaben.
                -> Kaffe holen!
                -> Loesung in den Praktomaten laden!

                job.zweck() verhält sich anderst da es eine statische Methode ist somit wird die von Job aufgerufen und ausgegeben.
                -> bringt Geld


*/
