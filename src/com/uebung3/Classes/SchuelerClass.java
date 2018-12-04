package com.uebung3.Classes;

import com.uebung3.Interfaces.SchuelerInterface;

import java.util.Date;

public class SchuelerClass extends PersonClass implements SchuelerInterface {

    private int katalognummer;
    private boolean eigenberechtigt;
    private Date eintrittsdatum;

    private KlasseClass klasse;

    public SchuelerClass(long svnr, String vorname, String nachname, Date geburtsdatum, String email, KlasseClass klasse) {
        super(svnr, vorname, nachname, geburtsdatum, email);
        this.klasse = klasse;
    }

    @Override
    public int getKatalognummer() { return this.katalognummer; }

    @Override
    public boolean isEigenberechtigt() {
        return this.eigenberechtigt;
    }

    @Override
    public Date getEintrittsdatum() {
        return this.eintrittsdatum;
    }

    @Override
    public KlasseClass getKlasse() { return this.klasse; }

    @Override
    public boolean setKlasse(KlasseClass klasse) {
        try {
            this.klasse = klasse;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
