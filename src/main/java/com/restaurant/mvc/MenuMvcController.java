package com.restaurant.mvc;

import com.restaurant.authorization.ViewResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuMvcController {

    @GetMapping("/menu")
    public String getMenuPage() {
        return ViewResolver.getRequestedView("menu");
    }
}
