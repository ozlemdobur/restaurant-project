package com.restaurant.service;

import com.restaurant.model.Reservation;
import java.util.Optional;

public interface ReservationService {
    public Iterable<Reservation> findAll();
    public Reservation makeReservation(Reservation reservation);
    public void deleteReservation(Long id);
    public Optional<Reservation> findByFirstName(String firstName);
}