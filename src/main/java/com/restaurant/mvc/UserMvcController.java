package com.restaurant.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMvcController {
    //  http://localhost:9090/user
    @GetMapping("/user")
    public String userPage(){

        return "user";

    }
}
