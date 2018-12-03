package com.uebung3.Classes;

import com.uebung3.Interfaces.MitarbeiterInterface;

import java.util.Date;

public abstract class MitarbeiterClass extends PersonClass implements MitarbeiterInterface {

    private static int anzahl = 0;          //Is a static variable correct?

    public MitarbeiterClass(long svnr, String vorname, String nachname, Date geburtsdatum, String email) {
        super(svnr, vorname, nachname, geburtsdatum, email);
        MitarbeiterClass.anzahl++;
    }

    @Override
    public int getAnzahl() {
        return MitarbeiterClass.anzahl;
    }
}
