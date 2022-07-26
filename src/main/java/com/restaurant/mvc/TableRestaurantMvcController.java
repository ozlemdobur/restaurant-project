package com.restaurant.mvc;

import com.restaurant.authorization.ViewResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableRestaurantMvcController {
    @GetMapping("/tables")
    public String tablesPage() {
        System.out.println("Here is inside tables admin!");
        return ViewResolver.getRequestedView("tables");
    }
}