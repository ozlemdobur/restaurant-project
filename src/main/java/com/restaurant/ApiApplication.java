package com.restaurant;

import com.restaurant.authorization.Session;
import com.restaurant.model.*;
import com.restaurant.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
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
    MenuRepository menuRepository;

    @Autowired
    IngredientRepository ingredientRepository;

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
        product = new Product(null, "Salmon", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Carrot", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Aubergine", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Sausage", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Cheese", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Nut", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Butter", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Sugar", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Rice", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Kip", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Apple", "liter", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);
        product = new Product(null, "Orange", "liter", 100.0, 10.0,"https://www.bol.com/nl/nl/","Groen",2D,2D);
        product1 = productRepository.save(product);

        Set<Ingredient> ingredientTomatoSoup = new HashSet<>();
        ingredientTomatoSoup.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(1)));
        ingredientTomatoSoup.add(new Ingredient(null,Double.valueOf(25),productRepository.findAll().get(4)));
        ingredientTomatoSoup.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(10)));
        ingredientRepository.saveAll(ingredientTomatoSoup);

        Set<Ingredient> ingredientChickenSoup = new HashSet<>();
        ingredientChickenSoup.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(14)));
        ingredientChickenSoup.add(new Ingredient(null,Double.valueOf(25),productRepository.findAll().get(3)));
        ingredientChickenSoup.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(11)));
        ingredientRepository.saveAll(ingredientChickenSoup);

        Set<Ingredient> ingredientSalad = new HashSet<>();
        ingredientSalad.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(1)));
        ingredientSalad.add(new Ingredient(null,Double.valueOf(25),productRepository.findAll().get(4)));
        ingredientSalad.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(6)));
        ingredientRepository.saveAll(ingredientSalad);

        Set<Ingredient> ingredientsBaklava = new HashSet<>();
        ingredientsBaklava.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(10)));
        ingredientsBaklava.add(new Ingredient(null,Double.valueOf(25),productRepository.findAll().get(11)));
        ingredientsBaklava.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(12)));
        ingredientRepository.saveAll(ingredientsBaklava);

        Set<Ingredient> ingredientsIce = new HashSet<>();
        ingredientsIce.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(3)));
        ingredientRepository.saveAll(ingredientsIce);

        Set<Ingredient> ingredientsSutlac = new HashSet<>();
        ingredientsSutlac.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(3)));
        ingredientsSutlac.add(new Ingredient(null,Double.valueOf(25),productRepository.findAll().get(13)));
        ingredientsSutlac.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(12)));
        ingredientRepository.saveAll(ingredientsSutlac);

        Set<Ingredient> ingredientsSalmon = new HashSet<>();
        ingredientsSalmon.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(5)));
        ingredientsSalmon.add(new Ingredient(null,Double.valueOf(25),productRepository.findAll().get(2)));
        ingredientsSalmon.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(6)));
        ingredientRepository.saveAll(ingredientsSalmon);

        Set<Ingredient> ingredientsAndijvie = new HashSet<>();
        ingredientsAndijvie.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(8)));
        ingredientsAndijvie.add(new Ingredient(null,Double.valueOf(25),productRepository.findAll().get(4)));
        ingredientsAndijvie.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(2)));
        ingredientsAndijvie.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(12)));
        ingredientRepository.saveAll(ingredientsAndijvie);

        Set<Ingredient> ingredientsKarniyarik = new HashSet<>();
        ingredientsKarniyarik.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(0)));
        ingredientsKarniyarik.add(new Ingredient(null,Double.valueOf(25),productRepository.findAll().get(1)));
        ingredientsKarniyarik.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(7)));
        ingredientsKarniyarik.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(9)));
        ingredientRepository.saveAll(ingredientsKarniyarik);

        Set<Ingredient> ingredientsAppleJuice = new HashSet<>();
        ingredientsAppleJuice.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(15)));
        ingredientRepository.saveAll(ingredientsAppleJuice);

        Set<Ingredient> ingredientsOrangeJuice = new HashSet<>();
        ingredientsOrangeJuice.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(16)));
        ingredientRepository.saveAll(ingredientsOrangeJuice);


       Menu menuSalmon = new Menu(null,"Salmon", BigDecimal.valueOf(10),"Maincourse","Salmon.png",ingredientsSalmon );
       menuRepository.save(menuSalmon);

        Menu menuSalad = new Menu(null,"Salad", BigDecimal.valueOf(10),"Starter","Salad.png",ingredientSalad );
        menuRepository.save(menuSalad);

        Menu menuTomatoSoup = new Menu(null,"Tomato Soup", BigDecimal.valueOf(12),"Starter","TomatoSoup.png",ingredientTomatoSoup );
        menuRepository.save(menuTomatoSoup);

        Menu menuChickenSoup = new Menu(null,"Chicken Soup", BigDecimal.valueOf(15),"Starter","ChickenSoup.png",ingredientChickenSoup );
        menuRepository.save(menuChickenSoup);

        Menu menuIce = new Menu(null,"Ice Cream", BigDecimal.valueOf(7),"Dessert","IceCream.png",ingredientsIce );
        menuRepository.save(menuIce);

        Menu menuBaklava = new Menu(null,"Baklava", BigDecimal.valueOf(15),"Dessert","Baklava.png",ingredientsBaklava );
        menuRepository.save(menuBaklava);

        Menu menuAndijvie = new Menu(null,"Andijvie Stammpot", BigDecimal.valueOf(20),"Maincourse","AndijvieStammpot.png",ingredientsAndijvie );
        menuRepository.save(menuAndijvie);

        Menu menuKarniyarik = new Menu(null,"Karniyarik", BigDecimal.valueOf(17),"Maincourse","Karniyarik.png",ingredientsKarniyarik );
        menuRepository.save(menuKarniyarik);

        Menu menuOrangeJuice = new Menu(null,"Orange Juice", BigDecimal.valueOf(5),"Drinks","OrangeJuice.png",ingredientsOrangeJuice );
        menuRepository.save(menuOrangeJuice);

        Menu menuAppleJuice = new Menu(null,"Apple Juice", BigDecimal.valueOf(5),"Drinks","AppleJuice.png",ingredientsAppleJuice);
        menuRepository.save(menuAppleJuice);

        Personnel user = new Personnel(null, "John", "de Witt", "witt", "AAaa11..", Session.getPersonnelRole("witt"));
        Personnel user2 = personnelRepository.save(user);
        user = new Personnel(null, "Ozlem", "Dobur", "odobur", "AAaa11..", Session.getPersonnelRole("odobur"));
        user2 = personnelRepository.save(user);
        user = new Personnel(null, "Ahmet", "Karabas", "akarabas", "AAaa11..", Session.getPersonnelRole("akarabas"));
        user2 = personnelRepository.save(user);
        user = new Personnel(null, "Nurullah", "Bayram", "nbayram", "AAaa11..", Session.getPersonnelRole("nbayram"));
        user2 = personnelRepository.save(user);

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

        Reservation reservation1 = new Reservation(null, "Nuri", "Bayram", "nbayram4@gmail.com", "06-84613844", LocalDate.parse("2022-07-14"), LocalTime.parse("11:30"), LocalTime.parse("11:30").plusHours(2), 6L, true, 601L);
        Reservation reservation2 = new Reservation(null, "Ahmet", "Kocadag", "akocabas@icloud.com", "06-12345678", LocalDate.parse("2022-07-14"), LocalTime.parse("15:30"),LocalTime.parse("11:30").plusHours(2), 6L, true, 602L);
        Reservation reservation3 = new Reservation(null, "Ozlem", "Dobur", "odobur@yandex.com", "06-87654321", LocalDate.parse("2022-07-14"), LocalTime.parse("14:00"),LocalTime.parse("14:00").plusHours(2), 8L, false, 801L);
        Reservation reservation4 = new Reservation(null, "John", "de Witt", "jdewitt@molveno.com", "06-12345678", LocalDate.parse("2022-07-14"), LocalTime.parse("20:00"),LocalTime.parse("22:00"), 8L, true, 802L);
        Reservation reservation5 = new Reservation(null, "Cor", "Broekhuis", "jdewitt@molveno.com", "06-12345678", LocalDate.parse("2022-07-14"), LocalTime.parse("20:00"),LocalTime.parse("22:00"), 8L, true, 803L);

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
        reservationRepository.save(reservation4);
        reservationRepository.save(reservation5);





    }
}