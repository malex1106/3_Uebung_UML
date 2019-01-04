package com.uebung3.Interfaces;

import com.uebung3.Classes.KlasseClass;

import java.time.LocalDate;
import java.util.Date;

public interface SchuelerInterface {
    public int getKatalognummer();
    public boolean isEigenberechtigt();
    public LocalDate getEintrittsdatum();
    public KlasseClass getKlasse();

    public boolean setKlasse(KlasseClass klasse);
    public boolean setEintrittsdatum(LocalDate eintrittsdatum);
    public boolean setKatalognummer(int katalognummer);
}
