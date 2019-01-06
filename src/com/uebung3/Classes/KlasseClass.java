package com.uebung3.Classes;

import com.uebung3.Interfaces.KlasseInterface;

import java.util.ArrayList;

public class KlasseClass implements KlasseInterface {

    private String bezeichnung;
    private int schulstufe;

    private LehrerClass klassenvorstand;
    private SchuelerClass klassensprecher;
    private ArrayList<SchuelerClass> schueler;
    private RaumClass stammklasse;
    private ArrayList<FachClass> faecher;           //Es kann ja nicht nur ein Fach unterrichtet werden, aber nur ein Fach einmal!
    private AbteilungClass abteilung;

    public KlasseClass(String bezeichnung, int schulstufe, AbteilungClass abteilung) {
        this.bezeichnung = bezeichnung;
        this.schulstufe = schulstufe;
        this.abteilung = abteilung;

        this.schueler = new ArrayList<SchuelerClass>();
        this.faecher = new ArrayList<FachClass>();
    }

    @Override
    public String getBezeichnung() {
        return this.bezeichnung;
    }

    @Override
    public int getSchulstufe() { return this.schulstufe; }

    @Override
    public float getDurchschnittsalter() {
        return 0;
    }

    @Override
    public int getSchuelerAnzahl() {
        return this.schueler.size();
    }

    @Override
    public AbteilungClass getAbteilung() { return this.abteilung; }

    @Override
    public ArrayList<SchuelerClass> getSchueler() { return this.schueler; }

    @Override
    public boolean setKlassensprecher(SchuelerClass schueler) {
        try {
            this.klassensprecher = schueler;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addSchueler(SchuelerClass schueler) {
        try {
            if(this.schueler.size() < 36) {
                this.schueler.add(schueler);
                return true;
            } else
                throw new Exception("Maximale Schueleranzahl erreicht!");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setKlassenvorstand(LehrerClass klassenvorstand) {
        try {
            this.klassenvorstand = klassenvorstand;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setStammklasse(RaumClass stammklasse) {
        try {
            this.stammklasse = stammklasse;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public RaumClass getStammklasse() { return this.stammklasse; }

    @Override
    public boolean addFach(FachClass fach) {
        try {
            if(!this.faecher.contains(fach)) {
                this.faecher.add(fach);
                return true;
            } else
                throw new Exception("Fach existiert bereits.");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setAbteilung(AbteilungClass abteilung) {
        try {
            this.abteilung = abteilung;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setBezeichnung(String bezeichnung) {
        try {
            this.bezeichnung = bezeichnung;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setSchulstufe(int schulstufe) {
        try {
            this.schulstufe = schulstufe;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public void exportStundenplan(ArrayList<BelegungClass> belegung) {

    }

}
