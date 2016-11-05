package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 05/11/16.
 */

public class MestreDeObra implements Serializable, IAdapter {

    private String nome;

    public MestreDeObra(String nome) {
        this.nome = nome;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return nome;
    }

    @Override
    public String getSubTitle() {
        return null;
    }

    @Override
    public float getValue() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public IAdapter getIAdapter() {
        return null;
    }
}
