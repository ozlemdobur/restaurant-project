package com.restaurant.controller;

import com.restaurant.model.Reservation;
import com.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // http://localhost:9090/api/reservation
    @GetMapping(value = "/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Reservation>> getAllReservations() {
        System.out.println("Inside getAllReservations");
        Iterable<Reservation> reservations = reservationService.findAll();
//        System.out.println(reservations.toString());
        return ResponseEntity.ok(reservations);
    }

    // http://localhost:9090/api/reservation
    @GetMapping(value = "/reservation/{firstName}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> getReservationsByName( @PathVariable String firstName){
        System.out.println("Inside getAllReservations");
        Reservation reservation = reservationService.findByFirstName(firstName).orElse(null);
        return ResponseEntity.ok(reservation);
    }

      // http://localhost:9090/api/reservation
    @PostMapping(value = "/reservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> makeReservation(@RequestBody Reservation reservation) {
        System.out.println("Inside makeReservation");
        Reservation reservationMade = reservationService.makeReservation(reservation);
        return ResponseEntity.ok(reservationMade);
    }

    // http://9090/api/customer/3
    @DeleteMapping(value = "/reservation/{id}", produces= MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteReservationById( @PathVariable Long id){
        System.out.println("Inside deleteReservationById");
        reservationService.deleteReservation(id);
        return ResponseEntity.ok( "Reservation with id: " + id + " is deleted");
    }
}