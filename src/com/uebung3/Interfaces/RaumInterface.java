package com.uebung3.Interfaces;

import com.uebung3.Classes.BelegungClass;
import com.uebung3.Classes.FachClass;
import com.uebung3.Classes.KlasseClass;
import com.uebung3.Enumerations.Raumtyp;

import java.util.ArrayList;

public interface RaumInterface {
    public String getRaumNummer();
    public void exportBelegung(ArrayList<BelegungClass> belegung);
    public int getMaxSitzplaetze();
    public Raumtyp getRaumtyp();
    public KlasseClass getStammklasse();
    public ArrayList<FachClass> getFaecher();

    public boolean setStammklasse(KlasseClass klasse);
    public boolean addFach(FachClass fach);
}
