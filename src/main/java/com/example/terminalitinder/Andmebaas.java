package com.example.terminalitinder;

import java.util.ArrayList;
import java.util.List;

public class Andmebaas {
    private List<Isik> andmed = new ArrayList<>();

    public Andmebaas() {
    }

    public List<Isik> getAndmed() {
        return andmed;
    }

    public void lisaIsik(Isik lisatav) {
        andmed.add(lisatav);
    }
}
