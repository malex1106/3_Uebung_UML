package com.uebung3.Classes;

import com.uebung3.Enumerations.Raumtyp;
import com.uebung3.Interfaces.FachInterface;

public class FachClass implements FachInterface {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getWochenstunden() {
        return 0;
    }

    @Override
    public Raumtyp getRaumanforderungen() {
        return null;
    }
}
