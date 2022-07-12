package com.restaurant.service;

import com.restaurant.exception.NoSuitableTableException;
import com.restaurant.model.Reservation;
import com.restaurant.model.TableRestaurant;
import com.restaurant.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;
    @Autowired
    private TableRestaurantServiceImpl imp;

    public ReservationServiceImpl() {
    }

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Iterable<Reservation> findAll() {
        Iterable<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

    @Override
    public Optional<Reservation> findByFirstName(String firstName) {
        return reservationRepository.findByFirstName(firstName);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}