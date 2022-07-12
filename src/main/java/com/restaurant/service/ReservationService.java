package com.restaurant.service;

import com.restaurant.exception.NoSuitableTableException;
import com.restaurant.model.Reservation;
import java.util.Optional;

public interface ReservationService {
    public Iterable<Reservation> findAll();
    public Optional<Reservation> findByFirstName(String firstName);
    public Reservation save(Reservation reservation);
    public void deleteById(Long id);
}
