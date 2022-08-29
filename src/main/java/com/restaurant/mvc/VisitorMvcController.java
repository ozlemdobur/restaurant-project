package com.restaurant.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitorMvcController {
    //  http://localhost:9090/visitor
    @GetMapping("/visitor")
    public String visitorPage(){

        return "visitor";

    }
}
