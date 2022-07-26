package com.restaurant.mvc;

import com.restaurant.authorization.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginMvcController {
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        System.out.println("Inside logoutPage");
        Session.invalidateSession();
        return "redirect:/home";
    }
}
