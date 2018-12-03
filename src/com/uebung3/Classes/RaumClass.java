package com.uebung3.Classes;

import com.uebung3.Enumerations.Raumtyp;
import com.uebung3.Interfaces.RaumInterface;

public class RaumClass implements RaumInterface {

    private String raumNummer;
    private int maxSitzolaetze;
    private Raumtyp raumtyp;

    @Override
    public String getRaumNummer() {
        return null;
    }

    @Override
    public void exportBelegung() {

    }

    @Override
    public int getMaxSitzplaetze() {
        return 0;
    }

    @Override
    public Raumtyp getRaumtyp() {
        return null;
    }
}
