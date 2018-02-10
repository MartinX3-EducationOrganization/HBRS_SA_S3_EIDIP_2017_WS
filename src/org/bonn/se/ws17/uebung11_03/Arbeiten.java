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

  public void start() {
    System.out.println("Kaffee holen!");
  }

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
