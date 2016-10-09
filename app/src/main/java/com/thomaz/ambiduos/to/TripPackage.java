package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 30/09/16.
 */

public class TripPackage implements Serializable, IBookers {

    private int id;
    private String name;
    private String sub;
    private float value;

    public TripPackage(String name, String sub, float value) {
        this.name = name;
        this.sub = sub;
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
        return sub;
    }

    @Override
    public float getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
