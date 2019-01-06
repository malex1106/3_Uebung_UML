package com.uebung3.Classes;

import com.uebung3.Interfaces.LehrerInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class LehrerClass extends MitarbeiterClass implements LehrerInterface {

    private String kuerzel;

    private ArrayList<FachClass> faecher;

    public LehrerClass(long svnr, String vorname, String nachname, LocalDate geburtsdatum, String email, String kuerzel) {
        super(svnr, vorname, nachname, geburtsdatum, email);
        this.kuerzel = kuerzel;
        this.faecher = new ArrayList<FachClass>();
    }

    @Override
    public String getKuerzel() {
        return this.kuerzel;
    }

    @Override
    public boolean addFach(FachClass fach) {
        try {
            this.faecher.add(fach);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<FachClass> getFaecher() { return this.faecher; }

    @Override
    public void exportStundenplan(ArrayList<BelegungClass> belegung) {

        for(int i=0; i<10; i++) {

            for (int j = 0; j < 5; j++) {

                for (BelegungClass belegung1 : belegung) {

                    if (belegung1.getLehrer().getKuerzel().equals(this.kuerzel)){
                        if(belegung1.getWochentag()==?? && belegung1.getStunde()==i){
                            //Ausgabe der Daten für diese Stunde!!! Folgende 3 Informationen sind relevant
                            //belegung1.getFach().getName();
                            //belegung1.getKlasse().getBezeichnung();
                            //belegung1.getRaum().getRaumNummer();
                        }
                    }

                }


            }
        }
    }
}