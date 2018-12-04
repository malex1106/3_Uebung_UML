package com.uebung3.Interfaces;

import com.uebung3.Classes.FachClass;
import com.uebung3.Classes.KlasseClass;
import com.uebung3.Classes.LehrerClass;
import com.uebung3.Enumerations.Raumtyp;

import java.util.ArrayList;

public interface FachInterface {
    public String getName();
    public int getWochenstunden();
    public Raumtyp getRaumanforderungen();
    public ArrayList<LehrerClass> getLehrer();
    public ArrayList<KlasseClass> getKlassen();

    public boolean addLehrer(LehrerClass lehrer);
    public boolean addKlasse(KlasseClass klasse);
}
