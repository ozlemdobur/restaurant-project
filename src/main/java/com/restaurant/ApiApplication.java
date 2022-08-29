package com.restaurant;

import com.restaurant.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

    @Autowired
    VisitorRepository userRepository;



    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
    /*    Visitor user = new Visitor(null, "John","de Witt", "50", "Utrecht");
        Visitor user2 = userRepository.save(user);
        user = new Visitor(null, "Ozlem", "Dobur", "50", "Utrecht");
        user2 = user2 = userRepository.save(user);
        user = new Visitor(null, "Ahmet", "Karabas", "50", "Utrecht");
        user2 = user2 = userRepository.save(user);
        user = new Visitor(null, "Nurullah", "Bayram", "50", "Utrecht");
        user2 = user2 = userRepository.save(user);
        user = new Visitor(null, "Cor", "Cor", "50", "Utrecht");
        user2 = user2 = userRepository.save(user);
*/

/*
        Set<Product> products = new HashSet<>();
        products.add(new Product(null, "Meat", "gram", 1000.0,20000.0,"https://www.bol.com/nl/nl/"));
        products.add(new Product(null, "Tomato", "gram", 10000.0, 120.0,"https://www.bol.com/nl/nl/"));
        products.add(new Product(null, "Potato", "gram", 15000.0, 120000.0,"https://www.bol.com/nl/nl/"));
        products.add(new Product(null, "Milk", "litre", 2000.0, 120.0,"https://www.bol.com/nl/nl/"));
        products.add(new Product(null, "lettuce", "piece", 100.0, 10.0,"https://www.bol.com/nl/nl/"));
        productRepository.saveAll(products);
        System.out.println(products.toString());

        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(1)));
        ingredients.add(new Ingredient(null,Double.valueOf(25),productRepository.findAll().get(2)));
        ingredients.add(new Ingredient(null,Double.valueOf(5),productRepository.findAll().get(3)));
        ingredientRepository.saveAll(ingredients);


        Ingredient ingredient = new Ingredient();
        ingredient.setIngAmount(Double.valueOf(5));
        Product product = productRepository.findAll().get(0);
        ingredient.setproduct(product);
        //ingredient.setMenu(menu);
        ingredientRepository.save(ingredient);

        Menu menu = new Menu(null,"Salad", BigDecimal.valueOf(20.0),"Starter","/df/df",ingredients );
        menuRepository.save(menu);
        //Menu menus = new Menu(null,"Kebap",BigDecimal.valueOf(25),"Main Course", "kk/kk",ingredients);
        //menuRepository.save(menus);
        System.out.println(menu.toString());

        System.out.println(menu.toString());*/
    }
}
