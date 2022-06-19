package com.restaurant.service;

import com.restaurant.model.Reservation;

public interface ReservationService {
    public Iterable<Reservation> findAll();
    public Reservation makeReservation(Reservation reservation);
}
