package com.uebung3.Classes;

import com.uebung3.Enumerations.Raumtyp;
import com.uebung3.Interfaces.FachInterface;

import java.util.ArrayList;

public class FachClass implements FachInterface {

    private String name;
    private int wochenstunden;
    private Raumtyp raumanforderung;

    private ArrayList<LehrerClass> lehrer;
    private ArrayList<KlasseClass> klassen;

    public FachClass(String name, int wochenstunden, Raumtyp raumanforderung) {
        this.name = name;
        this.wochenstunden = wochenstunden;
        this.raumanforderung = raumanforderung;

        lehrer = new ArrayList<LehrerClass>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWochenstunden() {
        return this.wochenstunden;
    }

    @Override
    public Raumtyp getRaumanforderungen() {
        return this.raumanforderung;
    }

    @Override
    public ArrayList<LehrerClass> getLehrer() { return this.lehrer; }

    @Override
    public boolean addLehrer(LehrerClass lehrer) {
        try {
            if(!this.lehrer.contains(lehrer)) {
                this.lehrer.add(lehrer);
                return true;
            } else
                throw new Exception("Lehrer existiert bereits!");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addKlasse(KlasseClass klasse) {
        try {
            if(!this.klassen.contains(klasse)) {
                this.klassen.add(klasse);
                return true;
            } else
                throw new Exception("Klasse existiert bereits!");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<KlasseClass> getKlassen() { return this.klassen; }
}
