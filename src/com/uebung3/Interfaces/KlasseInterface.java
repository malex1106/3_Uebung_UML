package com.uebung3.Interfaces;

import com.uebung3.Classes.*;

public interface KlasseInterface {
    public String getBezeichnung();
    public int getSchulstufe();
    public float getDurchschnittsalter();
    public RaumClass getStammklasse();
    public AbteilungClass getAbteilung();
    public int getSchuelerAnzahl();

    public boolean setKlassensprecher(SchuelerClass schueler);
    public boolean addSchueler(SchuelerClass schueler);
    public void exportStundenplan();
    public boolean setKlassenvorstand(LehrerClass klassenvorstand);
    public boolean setStammklasse(RaumClass stammklasse);
    public boolean addFach(FachClass fach);
    public boolean setAbteilung(AbteilungClass abteilung);
    public boolean setBezeichnung(String bezeichnung);
    public boolean setSchulstufe(int schulstufe);
}
