package com.uebung3.Classes;

import com.uebung3.Interfaces.SchuelerInterface;

import java.util.Date;

public class SchuelerClass implements SchuelerInterface {

    private int katalognummer;
    private boolean eigenberechtigt;
    private Date eintrittsdatum;

    @Override
    public int getKatalognummer() {
        return 0;
    }

    @Override
    public boolean isEigenberechtigt() {
        return false;
    }

    @Override
    public Date getEintrittsdatum() {
        return null;
    }
}
