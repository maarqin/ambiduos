package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 30/09/16.
 */
public abstract class Booking implements Serializable {

    private int id;
    private User usuario;
    private IBookers bookers;

    public Booking(int id, User usuario, IBookers bookers) {
        this.id = id;
        this.usuario = usuario;
        this.bookers = bookers;
    }

    public int getId() {
        return id;
    }

    public User getUsuario() {
        return usuario;
    }

    public IBookers getBookers() {
        return bookers;
    }
}
