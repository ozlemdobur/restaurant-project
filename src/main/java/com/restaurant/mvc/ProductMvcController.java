package com.restaurant.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductMvcController {

    @GetMapping("/product")
    public String getProductPage() {
        return "product";
    }
}
