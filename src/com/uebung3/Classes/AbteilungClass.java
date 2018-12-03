package com.uebung3.Classes;

import com.uebung3.Interfaces.AbteilungInterface;

public class AbteilungClass implements AbteilungInterface {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getKuerzel() {
        return null;
    }

    @Override
    public ArrayList<Schueler> getSchueler() {
        return null;
    }

    @Override
    public boolean addLehrer(Lehrer lehrer) {
        return false;
    }

    @Override
    public boolean setAbteilungsvorstand(Lehrer lehrer) {
        return false;
    }
}
