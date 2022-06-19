package com.restaurant;

import com.restaurant.model.Reservation;
import com.restaurant.repository.ReservationRepository;
import com.restaurant.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	ReservationRepository reservationRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Reservation reservation = new Reservation(0, "Nuri", "Bayram", "nbayram4@gmail.com", "0684613844", LocalDateTime.now(), 2, true);
//		reservationRepository.save(reservation);

		List<Reservation> reservations = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			reservations.add(new Reservation(0, Util.getFakeFirstName(), Util.getFakeLastName(), Util.getFakeEmail(), (String)Util.getFakePhone(), Util.getFakeDate(), Util.getFakeTime(), Util.getFakeAmountPerson(), true));
		}
		reservationRepository.saveAll(reservations);
	}
}