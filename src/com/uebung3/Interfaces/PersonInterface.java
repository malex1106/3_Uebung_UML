package com.uebung3.Interfaces;

import com.uebung3.Classes.AdresseClass;

import java.util.Date;

public interface PersonInterface {
    public long getSvnr();
    public String getVorname();
    public String getNachname();
    public Date getGeburtsdatum();
    public String getEmail();
    public AdresseClass getWohnort();

    public boolean setWohnort(AdresseClass wohnort);
}
