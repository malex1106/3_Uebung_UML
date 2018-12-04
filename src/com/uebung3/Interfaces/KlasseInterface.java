package com.uebung3.Interfaces;

import com.uebung3.Classes.LehrerClass;
import com.uebung3.Classes.SchuelerClass;

public interface KlasseInterface {
    public String getBezeichnung();
    public int getSchulstufe();
    public float getDurchschnittsalter();

    public boolean setKlassensprecher(SchuelerClass schueler);
    public boolean addSchueler(SchuelerClass schueler);
    public void exportStundenplan();
    public boolean setKlassenvorstand(LehrerClass klassenvorstand);
}
