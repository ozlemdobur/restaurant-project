package com.restaurant.mvc;

import org.springframework.web.bind.annotation.GetMapping;

public class MenuMvcController {
    @GetMapping("/menu")
    public String menuPage() {
        System.out.println("Here is inside reservation page!");
        return "menu";
    }
}
