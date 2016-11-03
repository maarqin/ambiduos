package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 02/11/16.
 */

public class Locacao implements Serializable, IAdapter  {

    private String nome;
    private String desc;

    public Locacao(String nome, String desc) {
        this.nome = nome;
        this.desc = desc;
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
        return desc;
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
