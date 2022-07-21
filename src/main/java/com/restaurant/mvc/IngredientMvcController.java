package com.restaurant.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IngredientMvcController {
    @GetMapping("/ingredient")
    public String getIngredientPage(@RequestParam String menuId) {
        return "ingredient";
    }
}
