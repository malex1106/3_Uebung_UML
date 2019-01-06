package com.uebung3.Classes;

import com.uebung3.Enumerations.Unterrichtstag;
import com.uebung3.Enumerations.Raumtyp;
import com.uebung3.Interfaces.BelegungInterface;

import java.util.ArrayList;

public class BelegungClass implements BelegungInterface {

    private int unterrichtsEinheit;
    private int stunde;
    private Unterrichtstag unterrichtstag;
    private KlasseClass klasse;
    private LehrerClass lehrer;
    private FachClass fach;
    private Raumtyp raum;

    private static int belegungNr = 0;

    BelegungClass () {

        unterrichtsEinheit = belegungNr;
        belegungNr++;

    }

    public BelegungClass(KlasseClass klasse, FachClass fach, LehrerClass lehrer, Unterrichtstag unterrichtstag, int stunde, Raumtyp raum) {
        this.klasse=klasse;
        this.unterrichtstag=unterrichtstag;
        this.stunde=stunde;

        ArrayList<LehrerClass> unterrichtende_lehrer = fach.getLehrer();
        try {

            if(unterrichtende_lehrer.contains(lehrer)){
                this.fach=fach;
                this.lehrer=lehrer;
            }else {
                throw new Exception("Dieses Fach wird von diesem Lehrer nicht unterrichtet");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Raumtyp raumanforderung = fach.getRaumanforderungen();
        try {

            if(raum==raumanforderung){
                this.raum=raum;
            }
            else {
                throw new Exception("Der gewählte Raum entspricht nicht den Raumanforderungen");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Unterrichtstag getWochentag() { return this.unterrichtstag; }

    @Override
    public KlasseClass getKlasse() { return this.klasse; }

    @Override
    public LehrerClass getLehrer() { return this.lehrer; }

    @Override
    public FachClass getFach() { return this.fach; }

    @Override
    public int getStunde() { return this.stunde; }

    @Override
    public Raumtyp getRaum() { return this.raum; }

}
