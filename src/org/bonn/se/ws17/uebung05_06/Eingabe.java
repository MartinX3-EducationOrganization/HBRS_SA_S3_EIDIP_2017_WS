package org.bonn.se.ws17.uebung05_06;


import java.util.Scanner;

public class Eingabe {

    public static void filter(String start, String stop, String skip) {
        String eingabe = "";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals(start)) {
                do {
                }
                while (!scanner.next().equals(stop));

            } else if (input.equals(skip)) {
                do {
                }
                while (scanner.nextLine().endsWith("\n"));
            } else {
                eingabe += input + " ";
            }
        }
        System.out.println(eingabe);
        scanner.close();
    }
}
