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
    private SchuelerClass schulsprecher;

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
            LehrerClass abteilungsvorstand;
            boolean a=false;
            for (AbteilungClass abteilungen1: abteilungen){
                abteilungsvorstand=abteilungen1.getAbteilungsvorstand();
                    if ((direktor==abteilungsvorstand) && (direktor != null)){
                        a=true;
                    }
            }
            if(a==true){
                throw new Exception("Dieser Lehrer ist schon Abteilungsvorstand");
            }
            else{
                this.direktor=direktor;
                return true;
            }
        }catch(Exception e){
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
   public boolean setSchulsprecher(SchuelerClass schueler) {
        try {
            this.schulsprecher = schueler;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
   }

    @Override
    public Long getSchulkennzahl() {

        return this.schulkennzahl;
    }

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public String getSchultyp() {

        return this.schultyp;
    }

    @Override
    public ArrayList<NichtLehrpersonal> getPersonal() {    //Laut Schule.svg ArrayList<MitarbeiterClass>
        return this.personal;
    }

    @Override
    public LehrerClass getDirektor() {   //Neu
        return this.direktor;
    }

    @Override
    public ArrayList<AbteilungClass> getAbteilungen() {
        return this.abteilungen;
    }

    @Override
    public ArrayList<LehrerClass> getLehrer() {
        ArrayList<LehrerClass> lehrer = new ArrayList<LehrerClass>();
        for (AbteilungClass abteilung: abteilungen){
            for (LehrerClass lehr: abteilung.getLehrer()) {
                if (!lehrer.contains(lehr))
                    lehrer.add(lehr);
            }
        }

        return lehrer;
    }

    @Override
    public int getSchuelerAnzahl() {
        int ergebnis=0;

        for (AbteilungClass abteilungen1: abteilungen){
            ergebnis += abteilungen1.getSchuelerAnzahl();
        }
        return ergebnis;
    }

    @Override
    public ArrayList<SchuelerClass> getSchueler() {
        ArrayList<SchuelerClass> schueler = new ArrayList<SchuelerClass>();
        for (AbteilungClass abteilung: this.abteilungen)
            for (SchuelerClass schueler1: abteilung.getSchueler())
                schueler.add(schueler1);

        return schueler;
    }

    @Override
    public SchuelerClass getSchulsprecher() { return this.schulsprecher; }

}
