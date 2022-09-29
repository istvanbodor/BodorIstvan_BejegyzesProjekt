package hu.petrik.bejegyzesprojekt;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Bejegyzes> bejegyzesek = new ArrayList<>();


    public static void main(String[] args) {

        bejegyzesek.add(new Bejegyzes("Bodor István","Ez egy bejegyzés"));
        bejegyzesek.add(new Bejegyzes("Bodor István","Ez a második bejegyzés"));


    }



}
