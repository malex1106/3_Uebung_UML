package com.uebung3.Classes;

import java.time.LocalDate;
import java.util.Date;

public class NichtLehrpersonal extends MitarbeiterClass{
    public NichtLehrpersonal(long svnr, String vorname, String nachname, LocalDate geburtsdatum, String email) {
        super(svnr, vorname, nachname, geburtsdatum, email);
    }
}
