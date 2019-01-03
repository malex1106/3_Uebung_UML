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
    public boolean setSvnr(long svnr) {
        try {
            this.svnr = svnr;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setVorname(String vorname) {
        try {
            this.vorname = vorname;
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setNachname(String nachname) {
        try {
            this.nachname = nachname;
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setGeburtsdatum(LocalDate geburtsdatum) {
        try {
            this.geburtsdatum = geburtsdatum;
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setEmail(String email) {
        try {
            this.email = email;
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
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
