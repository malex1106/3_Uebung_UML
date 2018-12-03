package com.uebung3.Interfaces;

public interface AbteilungInterface {
    public String getName();
    public String getKuerzel();
    public ArrayList<Schueler> getSchueler();

    public boolean addLehrer(Lehrer lehrer);
    public boolean setAbteilungsvorstand(Lehrer lehrer);
}
