package com.uebung3.Interfaces;

import com.uebung3.Classes.*;

import java.util.ArrayList;

public interface SchuleInterface {
    public boolean addPersonal(NichtLehrpersonal persona);
    public AbteilungClass addAbteilung(String name, String kuerzel);
    public boolean setDirektor(LehrerClass direktor);
    public boolean setStandort(AdresseClass adresse);

    public Long getSchulkennzahl();
    public String getName();
    public String getSchultyp();
    public ArrayList<MitarbeiterClass> getPersonal();
    public int getAnzahlSchueler();
}
