package com.uebung3.Classes;

import com.uebung3.Interfaces.AbteilungInterface;

import java.util.ArrayList;

public class AbteilungClass implements AbteilungInterface {

    private String kuerzel;
    private String name;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getKuerzel() {
        return null;
    }

    @Override
    public ArrayList<SchuelerClass> getSchueler() {
        return null;
    }

    @Override
    public boolean addLehrer(LehrerClass lehrer) {
        return false;
    }

    @Override
    public boolean setAbteilungsvorstand(LehrerClass lehrer) {
        return false;
    }
}