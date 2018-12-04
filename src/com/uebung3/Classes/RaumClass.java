package com.uebung3.Classes;

import com.uebung3.Enumerations.Raumtyp;
import com.uebung3.Interfaces.RaumInterface;

import java.util.ArrayList;

public class RaumClass implements RaumInterface {

    private String raumNummer;
    private int maxSitzplaetze;
    private Raumtyp raumtyp;

    private KlasseClass stammklasse;
    private ArrayList<FachClass> faecher;

    public RaumClass(String raumNummer, int maxSitzplaetze, Raumtyp raumtyp) {
        this.raumNummer = raumNummer;
        this.maxSitzplaetze = maxSitzplaetze;
        this.raumtyp = raumtyp;

        this.faecher = new ArrayList<FachClass>();
    }

    @Override
    public String getRaumNummer() {
        return this.raumNummer;
    }

    @Override
    public void exportBelegung() {

    }

    @Override
    public int getMaxSitzplaetze() {
        return this.maxSitzplaetze;
    }

    @Override
    public Raumtyp getRaumtyp() {
        return this.raumtyp;
    }

    @Override
    public boolean setStammklasse(KlasseClass klasse) {
        try {
            this.stammklasse = klasse;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public KlasseClass getStammklasse() { return this.stammklasse; }

    @Override
    public boolean addFach(FachClass fach) {
        try {
            if(!this.faecher.contains(fach)) {
                this.faecher.add(fach);
                return true;
            } else
                throw new Exception("Fach existiert bereits.");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<FachClass> getFaecher() { return this.faecher; }
}
