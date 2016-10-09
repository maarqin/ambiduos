package com.thomaz.ambiduos.to;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by thomaz on 30/09/16.
 */
public class User implements Serializable {

    private int id;
    private String nome;
    private ArrayList<Booking> bookings;

    public User(int id, String nome, ArrayList<Booking> bookings) {
        this.id = id;
        this.nome = nome;
        this.bookings = bookings;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

}
