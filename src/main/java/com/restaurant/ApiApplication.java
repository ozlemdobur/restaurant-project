package com.restaurant;

import com.restaurant.model.Personnel;
import com.restaurant.model.Product;
import com.restaurant.repository.PersonnelRepository;
import com.restaurant.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

    @Autowired
    PersonnelRepository personnelRepository;
    @Autowired
    ProductRepository productRepository;


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
    }
}
