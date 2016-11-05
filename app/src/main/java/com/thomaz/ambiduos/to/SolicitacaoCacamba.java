package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 02/11/16.
 */

public class SolicitacaoCacamba implements Serializable, IAdapter {

    private int sId;
    private String obra;
    private String tipo;

    public SolicitacaoCacamba(int sId, String obra, String tipo) {
        this.sId = sId;
        this.obra = obra;
        this.tipo = tipo;
    }

    @Override
    public int getId() {
        return sId;
    }

    @Override
    public String getName() {
        return "#" + sId + " [" + obra + "]";
    }

    @Override
    public String getSubTitle() {
        return tipo;
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
