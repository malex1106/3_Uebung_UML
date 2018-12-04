package com.uebung3.Classes;

import com.uebung3.Interfaces.LehrerInterface;

import java.util.ArrayList;
import java.util.Date;

public class LehrerClass extends MitarbeiterClass implements LehrerInterface {

    private String kuerzel;

    private ArrayList<FachClass> faecher;

    public LehrerClass(long svnr, String vorname, String nachname, Date geburtsdatum, String email, String kuerzel, FachClass fach) {       //Muss mindestens ein Fach abhalten!
        super(svnr, vorname, nachname, geburtsdatum, email);
        this.kuerzel = kuerzel;
        this.faecher = new ArrayList<FachClass>();

        this.faecher.add(fach);
    }

    @Override
    public String getKuerzel() {
        return this.kuerzel;
    }

    @Override
    public void exportStundenplan() {

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
}