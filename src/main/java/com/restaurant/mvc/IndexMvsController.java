package com.restaurant.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexMvsController {


    @GetMapping("/index")
    public String getProductPage() {
        return "index";
    }
}
