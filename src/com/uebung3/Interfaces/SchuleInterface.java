package com.uebung3.Interfaces;

public interface SchuleInterface {
    public boolean addPersonal(NichtLehrpersonal persona);
    public Abteilung addAbteilung(String name, String kuerzel);
    public boolean setDirektor(Lehrer lehrer);

    public Long getSchulkennzahl();
    public String getName();
    public String getSchultyp();
    public ArrayList<Mitarbeiter> getPersonal();
    public int getAnzahlSchueler();
}
