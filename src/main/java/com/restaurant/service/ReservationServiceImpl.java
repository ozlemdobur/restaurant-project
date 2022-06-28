package com.restaurant.service;

import com.restaurant.model.Reservation;
import com.restaurant.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    private ReservationRepository reservationRepository;

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
    public Reservation makeReservation(Reservation reservation) {
        Reservation reservationMade = reservationRepository.save(reservation);
        return reservationMade;
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Optional<Reservation> findByFirstName(String firstName) {
        return reservationRepository.findByFirstName(firstName);
    }
}