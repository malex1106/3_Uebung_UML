package com.uebung3.Classes;

import com.uebung3.Enumerations.Raumtyp;
import com.uebung3.Interfaces.FachInterface;

import java.util.ArrayList;

public class FachClass implements FachInterface {

    private String name;
    private int wochenstunden;
    private Raumtyp raumanforderung;

    private ArrayList<LehrerClass> lehrer;

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
            this.lehrer.add(lehrer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
