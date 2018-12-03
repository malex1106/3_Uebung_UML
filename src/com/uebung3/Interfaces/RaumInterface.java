package com.uebung3.Interfaces;

import com.uebung3.Enumerations.Raumtyp;

public interface RaumInterface {
    public String getRaumNummer();
    public void exportBelegung();
    public int getMaxSitzplaetze();
    public Raumtyp getRaumtyp();
}
