package com.restaurant.mvc;

import com.restaurant.authorization.ViewResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductMvcController {

    @GetMapping("/product")
    public String getProductPage() {
        return ViewResolver.getRequestedView("product");
    }
}
