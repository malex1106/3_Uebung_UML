package com.uebung3.Classes;

import com.uebung3.Interfaces.PersonInterface;

import java.util.Date;

public abstract class PersonClass implements PersonInterface {

    private long svnr;
    private String vorname;
    private String nachname;
    private Date geburtsdatum;
    private String email;

    public PersonClass(long svnr, String vorname, String nachname, Date geburtsdatum, String email) {
        this.svnr = svnr;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.email = email;
    }

    @Override
    public long getSvnr() {
        return 0;
    }

    @Override
    public String getVorname() {
        return null;
    }

    @Override
    public String getNachname() {
        return null;
    }

    @Override
    public Date getGeburtsdatum() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }
}
