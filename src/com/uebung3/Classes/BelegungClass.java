package com.uebung3.Classes;

import com.uebung3.Enumerations.Unterrichtstag;
import com.uebung3.Interfaces.BelegungInterface;

public class BelegungClass implements BelegungInterface {

    private int unterrichtsEinheit;

    @Override
    public Unterrichtstag getWochentag() {
        return null;
    }

    @Override
    public KlasseClass getKlasse() {
        return null;
    }

    @Override
    public LehrerClass getLehrer() {
        return null;
    }
}
