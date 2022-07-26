package com.restaurant.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexMvsController {

    @GetMapping("/")
    public String empty() {
        System.out.println("Inside emptyPage");
        return "index";
    }

    @GetMapping("/index")
    public String getProductPage() {
        return "index";
    }
}