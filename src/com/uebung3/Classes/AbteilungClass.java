package com.uebung3.Classes;

import com.uebung3.Interfaces.AbteilungInterface;
import java.util.ArrayList;

public class AbteilungClass implements AbteilungInterface {

    private String kuerzel;
    private String name;

    private SchuleClass schule;

    private LehrerClass abteilungsvorstand;
    private ArrayList<LehrerClass> unterrichtendeLehrer;
    private SchuelerClass abteilungssprecher;
    private ArrayList<KlasseClass> klassen;

    public AbteilungClass(String name, String kuerzel) {
        this.name = name;
        this.kuerzel = kuerzel;

        this.unterrichtendeLehrer = new ArrayList<LehrerClass>();
        this.klassen = new ArrayList<KlasseClass>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getKuerzel() {
        return this.kuerzel;
    }

    @Override
    public ArrayList<SchuelerClass> getSchueler() { return null; }  //gehört noch gemacht!!!

    @Override
    public LehrerClass getAbteilungsvorstand() { return this.abteilungsvorstand; }

    @Override
    public SchuelerClass getAbteilungssprecher() { return this.abteilungssprecher; }

    @Override
    public boolean addLehrer(LehrerClass lehrer) {
        try {
            if(!this.unterrichtendeLehrer.contains(lehrer)) {
                this.unterrichtendeLehrer.add(lehrer);
                return true;
            } else
                throw new Exception("Lehrer existiert bereits!");
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setAbteilungsvorstand(LehrerClass abteilungsvorstand) {
        try {
            LehrerClass lehrer=schule.getDirektor();

            if(lehrer==abteilungsvorstand) {
                throw new Exception("Dieser Lehrer ist schon Direktor!");
            }
            else{
                this.abteilungsvorstand=abteilungsvorstand;
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setAbteilungssprecher(SchuelerClass schueler) {
        try {
            this.abteilungssprecher = schueler;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setSchule(SchuleClass schule) {
        try {
            this.schule = schule;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addKlasse(KlasseClass klasse) {
        try {
            if(!this.klassen.contains(klasse)) {
                this.klassen.add(klasse);
                return true;
            } else
                throw new Exception("Klasse existiert bereits!");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<KlasseClass> getKlassen() { return this.klassen; }

    @Override
    public ArrayList<LehrerClass> getLehrer() { return this.unterrichtendeLehrer; }
}