package com.uebung3.Classes;

import com.uebung3.Interfaces.SchuleInterface;

import java.util.ArrayList;

public class SchuleClass implements SchuleInterface {

    private String name;
    private long schulkennzahl;
    private String schultyp;

    private ArrayList<AbteilungClass> abteilungen;
    private ArrayList<NichtLehrpersonal> personal;
    private AdresseClass standort;
    private LehrerClass direktor;

    public SchuleClass(String name, long schulkennzahl, String schultyp) {
        this.name = name;
        this.schulkennzahl = schulkennzahl;
        this.schultyp = schultyp;

        this.abteilungen = new ArrayList<AbteilungClass>();
        this.personal = new ArrayList<NichtLehrpersonal>();
    }

    @Override
    public boolean addPersonal(NichtLehrpersonal personal) {
        try {
            this.personal.add(personal);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public AbteilungClass addAbteilung(String name, String kuerzel) {
        try {
            AbteilungClass abteilung = new AbteilungClass(name, kuerzel);
            this.abteilungen.add(abteilung);
            return abteilung;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean setDirektor(LehrerClass direktor) {
        try {
            this.direktor = direktor;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setStandort(AdresseClass adresse) {
        try {
            this.standort = adresse;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
