package com.uebung3.Interfaces;

import com.uebung3.Classes.BelegungClass;
import com.uebung3.Classes.FachClass;

import java.util.ArrayList;

public interface LehrerInterface {
    public String getKuerzel();
    public void exportStundenplan(ArrayList<BelegungClass> belegung);
    public ArrayList<FachClass> getFaecher();

    public boolean addFach(FachClass fach);
}
