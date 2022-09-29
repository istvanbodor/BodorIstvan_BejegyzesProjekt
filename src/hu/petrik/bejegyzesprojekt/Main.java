package hu.petrik.bejegyzesprojekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
        veletlenlicit();
        masodikbejegyzesszoveg();
        kiir();
        legnepszerubb();
        vanetobb(35);
        hanyolyan(15);
        System.out.println("\n--------------------------------------------------------\n");
        rendezes();
        kiir();


    }

    private static void rendezes() {
        int n = bejegyzesek.size();


        for (int i = n - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (bejegyzesek.get(j).getLikeok() < bejegyzesek.get(j + 1).getLikeok()) {
                    Bejegyzes tmp = bejegyzesek.get(j);
                    bejegyzesek.set(j, bejegyzesek.get(j + 1));
                    bejegyzesek.set((j + 1), tmp);
                }


    }

    private static void hanyolyan(int szam) {
        int counter = 0;
        for (int i = 0; i < bejegyzesek.size(); i++) {

            if (bejegyzesek.get(i).getLikeok() < szam) {
                counter++;
            }
        }
        System.out.println();
        System.out.printf("%d %d-nél kevesebb likeot kapott bejegyzés van.", counter, szam);
    }

    private static void vanetobb(int mennyiazannyi) {
        boolean vane = false;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > mennyiazannyi) {
                vane = true;
            }
        }
        if (vane) {
            System.out.println();
            System.out.printf("Van olyan bejegyzés ami %d-nél töb likeot kapott.", mennyiazannyi);
        } else {
            System.out.println();
            System.out.printf("Nincs olyan bejegyzés ami %d-nél töb likeot kapott.", mennyiazannyi);
        }

    }

    private static void legnepszerubb() {
        int like = bejegyzesek.get(0).getLikeok();
        for (int i = 1; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > like) {
                like = bejegyzesek.get(i).getLikeok();
            }
        }
        System.out.printf("%d likeot kapott a legtöbbet kedvelt bejegyzés.", like);
    }


    private static void kiir() {

        for (int i = 0; i < bejegyzesek.size(); i++) {
            System.out.println(bejegyzesek.get(i));
        }

    }

    private static void masodikbejegyzesszoveg() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adja meg a második bejegyszés tartalmát!");
        String tart = sc.nextLine();
        bejegyzesek.get(1).setTartalom(tart);

    }

    private static void veletlenlicit() {
        for (int i = 0; i < (20 * bejegyzesek.size()); i++) {

            int festmenyIndex = (int) (Math.random() * bejegyzesek.size());
            bejegyzesek.get(festmenyIndex).like();
        }


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