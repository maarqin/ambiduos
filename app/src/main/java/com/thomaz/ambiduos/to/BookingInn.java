package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 30/09/16.
 */
public class BookingInn extends Booking implements Serializable {

    public BookingInn(int id, Inn bookers) {
        super(id, bookers);
    }
}
