package com.uebung3.Classes;

import com.uebung3.Interfaces.PersonInterface;

import java.util.Date;

public abstract class PersonClass implements PersonInterface {

    private Long svnr;
    private String vorname;
    private String nachname;
    private Date geburtsdatum;
    private String email;

    @Override
    public Long getSvnr() {
        return null;
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
