package com.restaurant;

import com.restaurant.model.Personnel;
import com.restaurant.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

    @Autowired
    PersonnelRepository personnelRepository;


    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Personnel user = new Personnel(null, "John", "de Witt", "witt", "***", "Admin");
        Personnel user2 = personnelRepository.save(user);
        user = new Personnel(null, "Ozlem", "Dobur", "odobur", "***", "Admin");
        user2 = personnelRepository.save(user);
        user = new Personnel(null, "Ahmet", "Karabas", "akarabas", "***", "Admin");
        user2 = personnelRepository.save(user);
        user = new Personnel(null, "Nurullah", "Bayram", "nbayram", "***", "Admin");
        user2 = personnelRepository.save(user);

    }
}
