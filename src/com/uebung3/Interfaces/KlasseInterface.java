package com.uebung3.Interfaces;

import com.uebung3.Classes.*;

import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

public interface KlasseInterface {
    public String getBezeichnung();
    public int getSchulstufe();
    public float getDurchschnittsalter();
    public RaumClass getStammklasse();
    public AbteilungClass getAbteilung();
    public int getSchuelerAnzahl();
    public ArrayList<SchuelerClass> getSchueler();
    public SchuelerClass getKlassensprecher();
    public LehrerClass getKlassenvorstand();

    public boolean setKlassensprecher(SchuelerClass schueler);
    public boolean addSchueler(SchuelerClass schueler);
    public void exportStundenplan(ArrayList<BelegungClass> belegung);
    public boolean setKlassenvorstand(LehrerClass klassenvorstand);
    public boolean setStammklasse(RaumClass stammklasse);
    public boolean addFach(FachClass fach);
    public boolean setAbteilung(AbteilungClass abteilung);
    public boolean setBezeichnung(String bezeichnung);
    public boolean setSchulstufe(int schulstufe);
}
