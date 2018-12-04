package com.uebung3.Classes;

import com.uebung3.Interfaces.KlasseInterface;

import java.util.ArrayList;

public class KlasseClass implements KlasseInterface {

    private String bezeichnung;
    private int schulstufe;

    private LehrerClass klassenvorstand;
    private SchuelerClass klassensprecher;
    private ArrayList<SchuelerClass> schueler;

    public KlasseClass(String bezeichnung, int schulstufe, LehrerClass klassenvorstand, SchuelerClass klassensprecher) {
        this.bezeichnung = bezeichnung;
        this.schulstufe = schulstufe;
        this.klassenvorstand = klassenvorstand;
        this.klassensprecher = klassensprecher;

        this.schueler = new ArrayList<SchuelerClass>();
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
    public void exportStundenplan() {

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
}
