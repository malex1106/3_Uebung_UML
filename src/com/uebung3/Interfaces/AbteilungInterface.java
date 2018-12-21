package com.uebung3.Interfaces;

import com.uebung3.Classes.KlasseClass;
import com.uebung3.Classes.LehrerClass;
import com.uebung3.Classes.SchuelerClass;
import com.uebung3.Classes.SchuleClass;

import java.util.ArrayList;

public interface AbteilungInterface {
    public String getName();
    public String getKuerzel();
    public ArrayList<SchuelerClass> getSchueler();
    public ArrayList<KlasseClass> getKlassen();
    public ArrayList<LehrerClass> getLehrer();
    public LehrerClass getAbteilungsvorstand();
    public SchuelerClass getAbteilungssprecher();
    public int getSchuelerAnzahl();

    public boolean addLehrer(LehrerClass lehrer);
    public boolean setAbteilungsvorstand(LehrerClass lehrer);
    public boolean setAbteilungssprecher(SchuelerClass schueler);
    public boolean addKlasse(KlasseClass klasse);
    public boolean setSchule(SchuleClass schule);

}
