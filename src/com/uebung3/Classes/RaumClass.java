package com.uebung3.Classes;

import com.uebung3.Enumerations.Raumtyp;
import com.uebung3.Enumerations.Unterrichtstag;
import com.uebung3.Interfaces.RaumInterface;

import java.util.ArrayList;

public class RaumClass implements RaumInterface {

    private String raumNummer;
    private int maxSitzplaetze;
    private Raumtyp raumtyp;

    private KlasseClass stammklasse;
    private ArrayList<FachClass> faecher;

    public RaumClass(String raumNummer, int maxSitzplaetze, Raumtyp raumtyp) {
        this.raumNummer = raumNummer;
        this.maxSitzplaetze = maxSitzplaetze;
        this.raumtyp = raumtyp;

        this.faecher = new ArrayList<FachClass>();
    }

    @Override
    public String getRaumNummer() {
        return this.raumNummer;
    }

    @Override
    public int getMaxSitzplaetze() {
        return this.maxSitzplaetze;
    }

    @Override
    public Raumtyp getRaumtyp() {
        return this.raumtyp;
    }

    @Override
    public boolean setStammklasse(KlasseClass klasse) {
        try {
            this.stammklasse = klasse;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public KlasseClass getStammklasse() { return this.stammklasse; }

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
    public ArrayList<FachClass> getFaecher() { return this.faecher; }


    @Override
    public void exportBelegung(ArrayList<BelegungClass> belegung) {

        for(int i=0; i<10; i++) {

            for (int j = 0; j < 5; j++) {

                for (BelegungClass belegung1 : belegung) {

                    if (belegung1.getRaum().getRaumNummer().equals(this.raumNummer)){
                        if(belegung1.getWochentag()== Unterrichtstag.values()[j] && belegung1.getStunde()==i){
                            //Ausgabe der Daten für diese Stunde!!! Folgende 3 Informationen sind relevant
                            //belegung1.getFach().getName();
                            //belegung1.getLehrer().getKuerzel();
                            //belegung1.getKlasse().getBezeichnung();
                        }
                    }

                }


            }
        }
    }

}
