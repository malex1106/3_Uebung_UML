package com.uebung3.Classes;

import com.uebung3.Interfaces.AdresseInterface;

public class AdresseClass implements AdresseInterface {

    private String ort;
    private String strasse;
    private int hausnummer;
    private int plz;

    @Override
    public String getOrt() {
        return null;
    }

    @Override
    public String getStrasse() {
        return null;
    }

    @Override
    public int getHausnummer() {
        return 0;
    }

    @Override
    public int getPlz() {
        return 0;
    }

    @Override
    public void printAdresse() {

    }
}
