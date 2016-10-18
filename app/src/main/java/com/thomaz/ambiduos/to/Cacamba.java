package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 18/10/16.
 */

public class Cacamba implements Serializable, IAdapter {

    private int id;
    private String name;
    private ClasseResiduo classeResiduo;
    private float value;

    public Cacamba(String name, ClasseResiduo classeResiduo, float value) {
        this.name = name;
        this.classeResiduo = classeResiduo;
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
        return classeResiduo;
    }
}
