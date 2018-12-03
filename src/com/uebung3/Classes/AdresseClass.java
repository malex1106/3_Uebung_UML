package com.uebung3.Classes;

import com.uebung3.Interfaces.AdresseInterface;

public class AdresseClass implements AdresseInterface {

    private String ort;
    private String strasse;
    private int hausnummer;
    private int plz;

    public AdresseClass(String ort, String strasse, int hausnummer, int plz) {
        this.ort =  ort;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
    }

    @Override
    public String getOrt() {
        return this.ort;
    }

    @Override
    public String getStrasse() {
        return this.strasse;
    }

    @Override
    public int getHausnummer() {
        return this.hausnummer;
    }

    @Override
    public int getPlz() {
        return this.plz;
    }

    @Override
    public void printAdresse() {
        System.out.println("Ort: " + this.getOrt() + " | Strasse: " + this.getStrasse() + " | " + this.getHausnummer() + " | " + this.getPlz());
    }
}
