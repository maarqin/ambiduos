package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 19/10/16.
 */

public class Residuo implements Serializable, IAdapter {

    private int id;
    private String name;
    private String descClasse;
    private float value;
    private Cacamba cacamba;

    public Residuo(String name, String descClasse, float value, Cacamba cacamba) {
        this.name = name;
        this.descClasse = descClasse;
        this.value = value;
        this.cacamba = cacamba;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSubTitle() {
        return null;
    }

    @Override
    public float getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return descClasse;
    }

    @Override
    public IAdapter getIAdapter() {
        return cacamba;
    }
}
