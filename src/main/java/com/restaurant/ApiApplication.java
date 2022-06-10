package com.restaurant;

import com.restaurant.model.User;
import com.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        User user = new User(null, "John", "de Witt", "witt", "***", "Admin");
        User user2 = userRepository.save(user);
        user = new User(null, "Ozlem", "Dobur", "odobur", "***", "Admin");
        user2 = userRepository.save(user);
        user = new User(null, "Ahmet", "Karabas", "akarabas", "***", "Admin");
        user2 = userRepository.save(user);
        user = new User(null, "Nurullah", "Bayram", "nbayram", "***", "Admin");
        user2 = userRepository.save(user);
    }
}
