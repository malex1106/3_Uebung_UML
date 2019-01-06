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
    private RaumClass raum;

    private static int belegungNr = 0;

    public BelegungClass(KlasseClass klasse, FachClass fach, LehrerClass lehrer, Unterrichtstag unterrichtstag, int stunde, RaumClass raum) {

        unterrichtsEinheit = belegungNr;
        belegungNr++;

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

            if(raum.getRaumtyp()==raumanforderung){
                if(klasse.getSchuelerAnzahl()>raum.getMaxSitzplaetze()){
                    throw new Exception("Der Raum hat nicht genügend Sitzplätze");
                }
                else{
                    this.raum=raum;
                }
            }
            else {
                throw new Exception("Der gewählte Raum entspricht nicht den Raumanforderungen");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        try {

            if (stunde <= 10) {
                this.stunde = stunde;
            } else {
                throw new Exception("Es gibt maximal 10Stunden");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        this.klasse = klasse;
        this.unterrichtstag = unterrichtstag;

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
    public RaumClass getRaum() { return this.raum; }

}
