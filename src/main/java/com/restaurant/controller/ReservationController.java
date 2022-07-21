package com.restaurant.controller;

import com.restaurant.exception.NoSuitableTableException;
import com.restaurant.model.Reservation;
import com.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.Optional;


@RestController
@RequestMapping("api")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController() {
    }

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // http://localhost:9090/api/reservationAdministration
    @GetMapping(value = "/reservationAdministration", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Reservation>> getAllReservations() {
        System.out.println("Inside getAllReservations");
        Iterable<Reservation> reservations = reservationService.findAll();
        return ResponseEntity.ok(reservations);
    }

    // http://9090/api/customer/3
    @DeleteMapping(value = "/reservationAdministration/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteReservationById(@PathVariable Long id) {
        System.out.println("Inside deleteReservationById");
        reservationService.deleteById(id);
        return ResponseEntity.ok("Reservation with id: " + id + " is deleted");
    }
    // http://localhost:9090/api/reservationAdministration

    @PostMapping(value = "/reservationAdministration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> makeReservation(@RequestBody Reservation reservation) throws NoSuitableTableException {
        System.out.println("Inside makeReservation");
        Reservation reservationMade = reservationService.save(reservation);
        return ResponseEntity.ok(reservationMade);
    }


    @PostMapping(value = "/makeReservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> checkAndMakeReservation(@RequestBody Reservation reservation){
        System.out.println("Inside checkAndMakeReservation");
        Reservation reservationMade = reservationService.checkAndMakeReservation(reservation);//reservationService.save(reservation);
        return ResponseEntity.ok(reservationMade);

    }

}