package com.uebung3.Classes;

import com.uebung3.Interfaces.KlasseInterface;

public class KlasseClass implements KlasseInterface {
    @Override
    public String getBezeichnung() {
        return null;
    }

    @Override
    public int getSchulstufe() {
        return 0;
    }

    @Override
    public float getDurchschnittsalter() {
        return 0;
    }

    @Override
    public boolean setKlassensprecher(SchuelerClass schueler) {
        return false;
    }

    @Override
    public boolean addSchueler(SchuelerClass schueler) {
        return false;
    }

    @Override
    public void exportStundenplan() {

    }
}
