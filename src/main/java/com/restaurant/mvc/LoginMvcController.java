package com.restaurant.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginMvcController {
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}
