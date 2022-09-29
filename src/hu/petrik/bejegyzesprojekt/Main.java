package hu.petrik.bejegyzesprojekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Bejegyzes> bejegyzesek = new ArrayList<>();


    public static void main(String[] args) {

        bejegyzesek.add(new Bejegyzes("Bodor István","Ez egy bejegyzés"));
        bejegyzesek.add(new Bejegyzes("Bodor István","Ez a második bejegyzés"));
        hozzafuzobekeres();


    }

    private static void hozzafuzobekeres()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adja meg hány bejegyzést szeretne felvenni: ");
        int db = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i <db ; i++) {
            System.out.printf("Adja meg a(z) %d bejegyzés szerzőjét:",i+1);
            String szerzo = sc.nextLine();
            System.out.printf("Adja meg a(z) %d bejegyzés tartalmát:", i+1);
            String tartalom = sc.nextLine();
            bejegyzesek.add(new Bejegyzes(szerzo, tartalom));
        }

    }
}