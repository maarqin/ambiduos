package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 30/09/16.
 */
public abstract class Booking implements Serializable {

    private int id;
    private IAdapter bookers;

    public Booking(int id, IAdapter bookers) {
        this.id = id;
        this.bookers = bookers;
    }

    public int getId() {
        return id;
    }

    public IAdapter getBookers() {
        return bookers;
    }
}
