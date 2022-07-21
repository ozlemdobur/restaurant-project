package com.restaurant.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SelectIngredientMvcController {

    @GetMapping("/selectingr")
    public String getSelectIngrPage() {
        return "selectingr";
    }
}
