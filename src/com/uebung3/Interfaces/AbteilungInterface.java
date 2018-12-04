package com.uebung3.Interfaces;

import com.uebung3.Classes.LehrerClass;
import com.uebung3.Classes.SchuelerClass;

import java.util.ArrayList;

public interface AbteilungInterface {
    public String getName();
    public String getKuerzel();
    public ArrayList<SchuelerClass> getSchueler();

    public boolean addLehrer(LehrerClass lehrer);
    public boolean setAbteilungsvorstand(LehrerClass lehrer);
    public boolean setAbteilungssprecher(SchuelerClass schueler);
}
