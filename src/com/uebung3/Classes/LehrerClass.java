package com.uebung3.Classes;

import com.uebung3.Interfaces.LehrerInterface;

import java.util.Date;

public class LehrerClass extends MitarbeiterClass implements LehrerInterface {

    private String kuerzel;

    public LehrerClass(long svnr, String vorname, String nachname, Date geburtsdatum, String email, String kuerzel) {
        super(svnr, vorname, nachname, geburtsdatum, email);
        this.kuerzel = kuerzel;
    }

    @Override
    public String getKuerzel() {
        return this.kuerzel;
    }

    @Override
    public void exportStundenplan() {

    }
}