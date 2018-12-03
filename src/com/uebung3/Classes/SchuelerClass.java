package com.uebung3.Classes;

import com.uebung3.Interfaces.SchuelerInterface;

import java.util.Date;

public class SchuelerClass implements SchuelerInterface {

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
