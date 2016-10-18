package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 18/10/16.
 */

public class Material implements Serializable, IAdapter {

    private int id;
    private String name;
    private UnidadeMedida un;
    private float value;

    public Material(String name, UnidadeMedida un, float value) {
        this.name = name;
        this.un = un;
        this.value = value;
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
        return null;
    }

    @Override
    public IAdapter getIAdapter() {
        return un;
    }
}
