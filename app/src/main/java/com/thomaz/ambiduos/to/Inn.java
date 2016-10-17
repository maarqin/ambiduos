package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 30/09/16.
 */
public class Inn implements Serializable, IAdapter {

    private int id;
    private String name;
    private String sub;
    private float value;

    public Inn(String name, String sub, float value) {
        this.name = name;
        this.sub = sub;
        this.value = value;
    }

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
