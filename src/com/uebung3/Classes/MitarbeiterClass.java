package com.uebung3.Classes;

import com.uebung3.Interfaces.MitarbeiterInterface;

import java.time.LocalDate;
import java.util.Date;

public abstract class MitarbeiterClass extends PersonClass implements MitarbeiterInterface {

    private static int anzahl = 0;          //Is a static variable correct?

    public MitarbeiterClass(long svnr, String vorname, String nachname, LocalDate geburtsdatum, String email) {
        super(svnr, vorname, nachname, geburtsdatum, email);
        MitarbeiterClass.anzahl++;
    }

    @Override
    public int getAnzahl() {
        return MitarbeiterClass.anzahl;
    }
}
