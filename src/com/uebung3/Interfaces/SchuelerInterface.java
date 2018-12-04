package com.uebung3.Interfaces;

import com.uebung3.Classes.KlasseClass;

import java.util.Date;

public interface SchuelerInterface {
    public int getKatalognummer();
    public boolean isEigenberechtigt();
    public Date getEintrittsdatum();
    public KlasseClass getKlasse();

    public boolean setKlasse(KlasseClass klasse);
}
