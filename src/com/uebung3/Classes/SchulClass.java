package com.uebung3.Classes;

import com.uebung3.Interfaces.SchuleInterface;

import java.util.ArrayList;

public class SchulClass implements SchuleInterface {

    @Override
    public boolean addPersonal(NichtLehrpersonal personal) {
        return false;
    }

    @Override
    public AbteilungClass addAbteilung(String name, String kuerzel) {
        return null;
    }

    @Override
    public boolean setDirektor(LehrerClass lehrer) {
        return false;
    }

    @Override
    public Long getSchulkennzahl() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSchultyp() {
        return null;
    }

    @Override
    public ArrayList<MitarbeiterClass> getPersonal() {
        return null;
    }

    @Override
    public int getAnzahlSchueler() {
        return 0;
    }
}
