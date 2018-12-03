package com.uebung3.Classes;

import com.uebung3.Interfaces.AbteilungInterface;

import java.util.ArrayList;

public class AbteilungClass implements AbteilungInterface {

    private String kuerzel;
    private String name;

    AbteilungClass(String name, String kuerzel) {
        this.name = name;
        this.kuerzel = kuerzel;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getKuerzel() {
        return this.kuerzel;
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