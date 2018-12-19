package com.uebung3.Classes;

import com.uebung3.Interfaces.PersonInterface;

import java.time.LocalDate;
import java.util.Date;

public abstract class PersonClass implements PersonInterface {

    private long svnr;
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;
    private String email;

    private AdresseClass wohnort;

    public PersonClass(long svnr, String vorname, String nachname, LocalDate geburtsdatum, String email) {
        this.svnr = svnr;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.email = email;
    }

    @Override
    public long getSvnr() {
        return this.svnr;
    }

    @Override
    public String getVorname() {
        return this.vorname;
    }

    @Override
    public String getNachname() {
        return this.nachname;
    }

    @Override
    public LocalDate getGeburtsdatum() {
        return this.geburtsdatum;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public AdresseClass getWohnort() {
        return this.wohnort;
    }

    @Override
    public boolean setWohnort(AdresseClass wohnort) {
        try {
            this.wohnort = wohnort;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
