package hu.petrik.bejegyzesprojekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Bejegyzes> bejegyzesek = new ArrayList<>();


    public static void main(String[] args) {

        bejegyzesek.add(new Bejegyzes("Bodor István", "Ez egy bejegyzés"));
        bejegyzesek.add(new Bejegyzes("Bodor István", "Ez a második bejegyzés"));

        try {
            hozzafuzobekeres();
        } catch (InputMismatchException e) {

            System.out.println("Nem megfelelő számot adott meg, nem lesz felvéve bejegyzés.");

        }
        String fajlNev = "bejegyzesek.csv";
        try {
            festmenyekHozzaadasaFajlbol("bejegyzesek.csv");
        } catch (FileNotFoundException e) {
            System.out.printf("Hiba történt a beolvasáskor a(z) %s fájl nem található\n", fajlNev);
        } catch (IOException e) {
            System.out.println("Ismeretlen hiba");
        }
        System.out.println(bejegyzesek);

    }

    private static void hozzafuzobekeres() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adja meg hány bejegyzést szeretne felvenni: ");
        int db = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < db; i++) {
            System.out.printf("Adja meg a(z) %d bejegyzés szerzőjét:", i + 1);
            String szerzo = sc.nextLine();
            System.out.printf("Adja meg a(z) %d bejegyzés tartalmát:", i + 1);
            String tartalom = sc.nextLine();
            bejegyzesek.add(new Bejegyzes(szerzo, tartalom));
        }

    }

    private static void festmenyekHozzaadasaFajlbol(String fajlNev) throws IOException {
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && !sor.equals("")) {

            String[] adatok = sor.split(";");
            Bejegyzes bejegyzes = new Bejegyzes(adatok[0], adatok[1]);
            bejegyzesek.add(bejegyzes);
            sor = br.readLine();
        }


    }


}