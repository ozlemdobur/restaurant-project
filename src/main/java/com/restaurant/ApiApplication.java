package com.restaurant;

import com.restaurant.model.Personnel;
import com.restaurant.model.Product;
import com.restaurant.model.Reservation;
import com.restaurant.model.TableRestaurant;
import com.restaurant.repository.PersonnelRepository;
import com.restaurant.repository.ProductRepository;
import com.restaurant.repository.ReservationRepository;
import com.restaurant.repository.TableRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

    @Autowired
    PersonnelRepository personnelRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    TableRestaurantRepository tableRestaurantRepository;

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

       Product product = new Product(null, "Meat", "gram", 1000.0,20000.0,"https://www.bol.com/nl/nl/","Dukes",20D,5D);
        Product product1 = productRepository.save(product);
        product = new Product(null, "Tomato", "gram", 10000.0, 120.0,"https://www.bol.com/nl/nl/","Ca",3D,1D);
        product1 = productRepository.save(product);
        product = new Product(null, "Potato", "gram", 15000.0, 120000.0,"https://www.bol.com/nl/nl/","Potat",5D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Milk", "litre", 2000.0, 120.0,"https://www.bol.com/nl/nl/","Milka",2D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Lettuce", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);

        TableRestaurant tableRestaurant1 = new TableRestaurant(null, 201L, 2L);
        TableRestaurant tableRestaurant2 = new TableRestaurant(null, 202L, 2L);
        TableRestaurant tableRestaurant3 = new TableRestaurant(null, 203L, 2L);
        TableRestaurant tableRestaurant4 = new TableRestaurant(null, 204L, 2L);

        TableRestaurant tableRestaurant5 = new TableRestaurant(null, 401L, 4L);
        TableRestaurant tableRestaurant6 = new TableRestaurant(null, 402L, 4L);
        TableRestaurant tableRestaurant7 = new TableRestaurant(null, 403L, 4L);
        TableRestaurant tableRestaurant8 = new TableRestaurant(null, 404L, 4L);
        TableRestaurant tableRestaurant9 = new TableRestaurant(null, 405L, 4L);
        TableRestaurant tableRestaurant10 = new TableRestaurant(null, 406L, 4L);
        TableRestaurant tableRestaurant11 = new TableRestaurant(null, 407L,4L);
        TableRestaurant tableRestaurant12 = new TableRestaurant(null, 408L,4L);
        TableRestaurant tableRestaurant13 = new TableRestaurant(null, 409L, 4L);
        TableRestaurant tableRestaurant14 = new TableRestaurant(null, 410L, 4L);
        TableRestaurant tableRestaurant15 = new TableRestaurant(null, 411L,4L);
        TableRestaurant tableRestaurant16 = new TableRestaurant(null, 412L,4L);

        TableRestaurant tableRestaurant17 = new TableRestaurant(null, 601L, 6L);
        TableRestaurant tableRestaurant18 = new TableRestaurant(null, 602L, 6L);
        TableRestaurant tableRestaurant19 = new TableRestaurant(null, 603L, 6L);

        TableRestaurant tableRestaurant20 = new TableRestaurant(null, 801L, 8L);
        TableRestaurant tableRestaurant21 = new TableRestaurant(null, 802L, 8L);
        TableRestaurant tableRestaurant22 = new TableRestaurant(null, 803L, 8L);
        TableRestaurant tableRestaurant23 = new TableRestaurant(null, 804L, 8L);

        tableRestaurantRepository.save(tableRestaurant1);
        tableRestaurantRepository.save(tableRestaurant2);
        tableRestaurantRepository.save(tableRestaurant3);
        tableRestaurantRepository.save(tableRestaurant4);
        tableRestaurantRepository.save(tableRestaurant5);
        tableRestaurantRepository.save(tableRestaurant6);
        tableRestaurantRepository.save(tableRestaurant7);
        tableRestaurantRepository.save(tableRestaurant8);
        tableRestaurantRepository.save(tableRestaurant9);
        tableRestaurantRepository.save(tableRestaurant10);
        tableRestaurantRepository.save(tableRestaurant11);
        tableRestaurantRepository.save(tableRestaurant12);
        tableRestaurantRepository.save(tableRestaurant13);
        tableRestaurantRepository.save(tableRestaurant14);
        tableRestaurantRepository.save(tableRestaurant15);
        tableRestaurantRepository.save(tableRestaurant16);
        tableRestaurantRepository.save(tableRestaurant17);
        tableRestaurantRepository.save(tableRestaurant18);
        tableRestaurantRepository.save(tableRestaurant19);
        tableRestaurantRepository.save(tableRestaurant20);
        tableRestaurantRepository.save(tableRestaurant21);
        tableRestaurantRepository.save(tableRestaurant22);
        tableRestaurantRepository.save(tableRestaurant23);

        Reservation reservation1 = new Reservation(null, "Nuri", "Bayram", "nbayram4@gmail.com", "06-84613844", LocalDate.parse("2022-07-14"), LocalTime.parse("11:30"), LocalTime.parse("11:30").plusHours(2), 5L, true, 601L);
        Reservation reservation2 = new Reservation(null, "Ahmet", "Kocadag", "akocabas@icloud.com", "06-12345678", LocalDate.parse("2022-07-14"), LocalTime.parse("15:30"),LocalTime.parse("11:30").plusHours(2), 6L, true, 602L);
        Reservation reservation3 = new Reservation(null, "Ozlem", "Dobur", "odobur@yandex.com", "06-87654321", LocalDate.parse("2022-07-14"), LocalTime.parse("14:00"),LocalTime.parse("14:00").plusHours(2), 7L, false, 801L);
        Reservation reservation4 = new Reservation(null, "John", "de Witt", "jdewitt@molveno.com", "06-12345678", LocalDate.parse("2022-07-14"), LocalTime.parse("20:00"),LocalTime.parse("22:00"), 8L, true, 802L);
        Reservation reservation5 = new Reservation(null, "Cor", "Broekhuis", "jdewitt@molveno.com", "06-12345678", LocalDate.parse("2022-07-14"), LocalTime.parse("20:00"),LocalTime.parse("22:00"), 8L, true, 803L);


//        TableRestaurant tableRestaurant5 = new TableRestaurant(0, 401, 4, false);
//        TableRestaurant tableRestaurant6 = new TableRestaurant(0, 402, 4, false);
//        TableRestaurant tableRestaurant7 = new TableRestaurant(0, 403, 4, false);
//        TableRestaurant tableRestaurant8 = new TableRestaurant(0, 404, 4, true);
//        TableRestaurant tableRestaurant9 = new TableRestaurant(0, 405, 4, false);
//        TableRestaurant tableRestaurant10 = new TableRestaurant(0, 406, 4, false);
//        TableRestaurant tableRestaurant11 = new TableRestaurant(0, 407, 4, false);
//        TableRestaurant tableRestaurant12= new TableRestaurant(0, 408, 4, true);
//        TableRestaurant tableRestaurant13 = new TableRestaurant(0, 409, 4, false);
//        TableRestaurant tableRestaurant14 = new TableRestaurant(0, 410, 4, false);
//        TableRestaurant tableRestaurant15 = new TableRestaurant(0, 411, 4, false);
//        TableRestaurant tableRestaurant16 = new TableRestaurant(0, 412, 4, true);
//
//        TableRestaurant tableRestaurant17 = new TableRestaurant(0, 601, 6, false);
//        TableRestaurant tableRestaurant18 = new TableRestaurant(0, 602, 6, false);
//        TableRestaurant tableRestaurant19 = new TableRestaurant(0, 603, 6, true);
//
//        TableRestaurant tableRestaurant20 = new TableRestaurant(0, 801, 8, false);
//        TableRestaurant tableRestaurant21 = new TableRestaurant(0, 802, 8, false);
//        TableRestaurant tableRestaurant22 = new TableRestaurant(0, 803, 8, false);
//        TableRestaurant tableRestaurant23 = new TableRestaurant(0, 804, 8, true);


//        tableRestaurantRepository.save(tableRestaurant5);
//        tableRestaurantRepository.save(tableRestaurant6);
//        tableRestaurantRepository.save(tableRestaurant7);
//        tableRestaurantRepository.save(tableRestaurant8);
//        tableRestaurantRepository.save(tableRestaurant9);
//        tableRestaurantRepository.save(tableRestaurant10);
//        tableRestaurantRepository.save(tableRestaurant11);
//        tableRestaurantRepository.save(tableRestaurant12);
//        tableRestaurantRepository.save(tableRestaurant13);
//        tableRestaurantRepository.save(tableRestaurant14);
//        tableRestaurantRepository.save(tableRestaurant15);
//        tableRestaurantRepository.save(tableRestaurant16);
//        tableRestaurantRepository.save(tableRestaurant17);
//        tableRestaurantRepository.save(tableRestaurant18);
//        tableRestaurantRepository.save(tableRestaurant19);
//        tableRestaurantRepository.save(tableRestaurant20);
//        tableRestaurantRepository.save(tableRestaurant21);
//        tableRestaurantRepository.save(tableRestaurant22);
//        tableRestaurantRepository.save(tableRestaurant23);

        TableRestaurant tableRestaurant1 = new TableRestaurant(null, 201L, 2L,LocalDate.of(2022, 07, 11), LocalTime.of(10, 00), LocalTime.of(10, 00).plusHours(3));
        TableRestaurant tableRestaurant2 = new TableRestaurant(null, 202L, 2L,LocalDate.of(2022, 07, 11), LocalTime.of(15, 00), LocalTime.of(15, 00).plusHours(3));
        TableRestaurant tableRestaurant3 = new TableRestaurant(null, 203L, 2L,LocalDate.of(2022, 07, 11), LocalTime.of(16, 00), LocalTime.of(16, 00).plusHours(3));
        TableRestaurant tableRestaurant4 = new TableRestaurant(null, 204L, 2L,LocalDate.of(2022, 07, 11), LocalTime.of(18, 00), LocalTime.of(18, 00).plusHours(3));

/*        TableRestaurant tableRestaurant5 = new TableRestaurant(0, 401, 4, false);
        TableRestaurant tableRestaurant6 = new TableRestaurant(0, 402, 4, false);
        TableRestaurant tableRestaurant7 = new TableRestaurant(0, 403, 4, false);*/
        /*TableRestaurant tableRestaurant8 = new TableRestaurant(0, 404, 4, true);
        TableRestaurant tableRestaurant9 = new TableRestaurant(0, 405, 4, false);
        TableRestaurant tableRestaurant10 = new TableRestaurant(0, 406, 4, false);
        TableRestaurant tableRestaurant11 = new TableRestaurant(0, 407, 4, false);
        TableRestaurant tableRestaurant12= new TableRestaurant(0, 408, 4, true);
        TableRestaurant tableRestaurant13 = new TableRestaurant(0, 409, 4, false);
        TableRestaurant tableRestaurant14 = new TableRestaurant(0, 410, 4, false);
        TableRestaurant tableRestaurant15 = new TableRestaurant(0, 411, 4, false);
        TableRestaurant tableRestaurant16 = new TableRestaurant(0, 412, 4, true);

        TableRestaurant tableRestaurant17 = new TableRestaurant(0, 601, 6, false);
        TableRestaurant tableRestaurant18 = new TableRestaurant(0, 602, 6, false);
        TableRestaurant tableRestaurant19 = new TableRestaurant(0, 603, 6, true);

        TableRestaurant tableRestaurant20 = new TableRestaurant(0, 801, 8, false);
        TableRestaurant tableRestaurant21 = new TableRestaurant(0, 802, 8, false);
        TableRestaurant tableRestaurant22 = new TableRestaurant(0, 803, 8, false);
        TableRestaurant tableRestaurant23 = new TableRestaurant(0, 804, 8, true);*/

        tableRestaurantRepository.save(tableRestaurant1);
        tableRestaurantRepository.save(tableRestaurant2);
        tableRestaurantRepository.save(tableRestaurant3);
        tableRestaurantRepository.save(tableRestaurant4);
        /*tableRestaurantRepository.save(tableRestaurant5);
        tableRestaurantRepository.save(tableRestaurant6);
        tableRestaurantRepository.save(tableRestaurant7);
        tableRestaurantRepository.save(tableRestaurant8);
        tableRestaurantRepository.save(tableRestaurant9);
        tableRestaurantRepository.save(tableRestaurant10);
        tableRestaurantRepository.save(tableRestaurant11);
        tableRestaurantRepository.save(tableRestaurant12);
        tableRestaurantRepository.save(tableRestaurant13);
        tableRestaurantRepository.save(tableRestaurant14);
        tableRestaurantRepository.save(tableRestaurant15);
        tableRestaurantRepository.save(tableRestaurant16);
        tableRestaurantRepository.save(tableRestaurant17);
        tableRestaurantRepository.save(tableRestaurant18);
        tableRestaurantRepository.save(tableRestaurant19);
        tableRestaurantRepository.save(tableRestaurant20);
        tableRestaurantRepository.save(tableRestaurant21);
        tableRestaurantRepository.save(tableRestaurant22);
        tableRestaurantRepository.save(tableRestaurant23);*/

        Reservation reservation1 = new Reservation(null, "Nuri", "Bayram", "nbayram4@gmail.com", "06-84613844", LocalDate.now(), LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute()), 2L, true, tableRestaurant1);
        Reservation reservation2 = new Reservation(null, "Ahmet", "Kocadag", "akocabas@icloud.com", "06-12345678", LocalDate.parse("2022-07-01"), LocalTime.parse("11:30"), 5L, true, tableRestaurant2);
        Reservation reservation3 = new Reservation(null, "Ozlem", "Dobur", "odobur@yandex.com", "06-87654321", LocalDate.parse("2022-07-04"), LocalTime.parse("14:00"), 1L, false, tableRestaurant3);
        Reservation reservation4 = new Reservation(null, "John", "de Witt", "jdewitt@molveno.com", "06-12345678", LocalDate.parse("2022-07-14"), LocalTime.parse("21:00"), 3L, true, tableRestaurant4);
        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
        reservationRepository.save(reservation4);
        reservationRepository.save(reservation5);

    }
}