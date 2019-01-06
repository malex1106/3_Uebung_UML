package com.uebung3.Classes;

import com.uebung3.Interfaces.SchuelerInterface;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class SchuelerClass extends PersonClass implements SchuelerInterface {

    private int katalognummer;
    private boolean eigenberechtigt;
    private LocalDate eintrittsdatum;

    private KlasseClass klasse;

    public SchuelerClass(long svnr, String vorname, String nachname, LocalDate geburtsdatum, String email) {
        super(svnr, vorname, nachname, geburtsdatum, email);
    }

    @Override
    public int getKatalognummer() { return this.katalognummer; }

    @Override
    public boolean isEigenberechtigt() {
        Period p = Period.between(this.getGeburtsdatum(), LocalDate.now());
        if (p.getYears() >= 18)
            eigenberechtigt = true;
        else
            eigenberechtigt = false;
        return this.eigenberechtigt;
    }

    @Override
    public LocalDate getEintrittsdatum() {
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

    @Override
    public boolean setEintrittsdatum(LocalDate eintrittsdatum) {
        try {
            this.eintrittsdatum = eintrittsdatum;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setKatalognummer(int katalognummer) {
        try {
            this.katalognummer = katalognummer;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

