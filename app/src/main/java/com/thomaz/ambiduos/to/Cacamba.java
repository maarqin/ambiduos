package com.thomaz.ambiduos.to;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by thomaz on 18/10/16.
 */

public class Cacamba implements Serializable, IAdapter, Comparable<Cacamba> {

    private Integer id;
    private String name;
    private ClasseResiduo classeResiduo;
    private float value;

    public Cacamba(Integer id) {
        this.id = id;
    }

    public Cacamba(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public int compareTo(@NonNull Cacamba cacamba) {
        return this.id.compareTo(cacamba.id);
    }
}
