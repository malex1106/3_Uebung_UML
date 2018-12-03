package com.uebung3.Interfaces;

import com.uebung3.Classes.KlasseClass;
import com.uebung3.Classes.LehrerClass;
import com.uebung3.Enumerations.Unterrichtstag;

public interface BelegungInterface {
    public Unterrichtstag getWochentag();
    public KlasseClass getKlasse();
    public LehrerClass getLehrer();
}
