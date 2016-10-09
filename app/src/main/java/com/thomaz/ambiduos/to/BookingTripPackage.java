package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 30/09/16.
 */
public class BookingTripPackage extends Booking implements Serializable {

    public BookingTripPackage(int id, User usuario, TripPackage bookers) {
        super(id, usuario, bookers);
    }
}
