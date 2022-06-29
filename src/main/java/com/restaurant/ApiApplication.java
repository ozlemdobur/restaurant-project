package com.restaurant;

import com.restaurant.model.Personnel;
import com.restaurant.model.Product;
import com.restaurant.model.Reservation;
import com.restaurant.repository.PersonnelRepository;
import com.restaurant.repository.ProductRepository;
import com.restaurant.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

    @Autowired
    PersonnelRepository personnelRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReservationRepository reservationRepository;


    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Personnel user = new Personnel(null, "John", "de Witt", "witt", "AAaa11..", "Admin");
        Personnel user2 = personnelRepository.save(user);
        user = new Personnel(null, "Ozlem", "Dobur", "odobur", "AAaa11..", "Admin");
        user2 = personnelRepository.save(user);
        user = new Personnel(null, "Ahmet", "Karabas", "akarabas", "AAaa11..", "Admin");
        user2 = personnelRepository.save(user);
        user = new Personnel(null, "Nurullah", "Bayram", "nbayram", "AAaa11..", "Admin");
        user2 = personnelRepository.save(user);

       Product product = new Product(null, "Meat", "gram", 1000.0,20000.0,"https://www.bol.com/nl/nl/");
        Product product1 = productRepository.save(product);
        product = new Product(null, "Tomato", "gram", 10000.0, 120.0,"https://www.bol.com/nl/nl/");
        product1 = productRepository.save(product);
        product = new Product(null, "Potato", "gram", 15000.0, 120000.0,"https://www.bol.com/nl/nl/");
        product1 = productRepository.save(product);
        product = new Product(null, "Milk", "litre", 2000.0, 120.0,"https://www.bol.com/nl/nl/");
        product1 = productRepository.save(product);
        product = new Product(null, "lettuce", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/");
        product1 = productRepository.save(product);

        Reservation reservation1 = new Reservation(0, "Nuri", "Bayram", "nbayram4@gmail.com", "06-84613844", LocalDate.now(), LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute()), 2, true);
        Reservation reservation2 = new Reservation(0, "Ahmet", "Kocadag", "akocadag@icloud.com", "06-12345678", LocalDate.parse("2022-07-12"), LocalTime.parse("11:00"), 3, false);
        Reservation reservation3 = new Reservation(0, "Ozlem", "Dobur", "odobur@yandex.com", "06-87654321", LocalDate.parse("2022-07-23"), LocalTime.parse("11:30"), 1, false);
        Reservation reservation4 = new Reservation(0, "John", "de Witt", "jdewitt@molvenohotel.com", "06-4561133", LocalDate.parse("2022-07-01"), LocalTime.parse("15:30"), 4, false);

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
        reservationRepository.save(reservation4);
    }
}
