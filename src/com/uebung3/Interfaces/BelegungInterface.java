package com.uebung3.Interfaces;

import com.uebung3.Classes.FachClass;
import com.uebung3.Classes.KlasseClass;
import com.uebung3.Classes.LehrerClass;
import com.uebung3.Enumerations.Raumtyp;
import com.uebung3.Enumerations.Unterrichtstag;

public interface BelegungInterface {
    public Unterrichtstag getWochentag();
    public KlasseClass getKlasse();
    public LehrerClass getLehrer();
    public FachClass getFach();
    public int getStunde();
    public Raumtyp getRaum();
}
