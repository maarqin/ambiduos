package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 16/10/16.
 */

public class Projetc implements Serializable, IAdapter {

    private int id;
    private String name;
    private String endereco;

    public Projetc(String name, String endereco) {
        this.name = name;
        this.endereco = endereco;
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
        return endereco;
    }

    @Override
    public float getValue() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
