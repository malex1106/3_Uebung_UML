package com.uebung3.Interfaces;

import com.uebung3.Classes.FachClass;
import com.uebung3.Classes.LehrerClass;
import com.uebung3.Classes.RaumClass;
import com.uebung3.Classes.SchuelerClass;

public interface KlasseInterface {
    public String getBezeichnung();
    public int getSchulstufe();
    public float getDurchschnittsalter();
    public RaumClass getStammklasse();

    public boolean setKlassensprecher(SchuelerClass schueler);
    public boolean addSchueler(SchuelerClass schueler);
    public void exportStundenplan();
    public boolean setKlassenvorstand(LehrerClass klassenvorstand);
    public boolean setStammklasse(RaumClass stammklasse);
    public boolean addFach(FachClass fach);
}
