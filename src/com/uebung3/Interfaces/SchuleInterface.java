package com.uebung3.Interfaces;

import com.uebung3.Classes.AbteilungClass;
import com.uebung3.Classes.LehrerClass;
import com.uebung3.Classes.MitarbeiterClass;
import com.uebung3.Classes.NichtLehrpersonal;

import java.util.ArrayList;

public interface SchuleInterface {
    public boolean addPersonal(NichtLehrpersonal persona);
    public AbteilungClass addAbteilung(String name, String kuerzel);
    public boolean setDirektor(LehrerClass lehrer);

    public Long getSchulkennzahl();
    public String getName();
    public String getSchultyp();
    public ArrayList<MitarbeiterClass> getPersonal();
    public int getAnzahlSchueler();
}
