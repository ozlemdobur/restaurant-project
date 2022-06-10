package com.restaurant.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainSystemMvcController {
    @GetMapping("/mainsystem")
    public String getLoginPage() {
        return "mainsystem";
    }
}
