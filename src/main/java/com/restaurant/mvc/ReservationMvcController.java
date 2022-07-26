package com.restaurant.mvc;

import com.restaurant.authorization.ViewResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationMvcController {

    @GetMapping("/reservationAdministration")
    public String reservationAdmin() {
        System.out.println("Here is inside reservation admin!");
        return ViewResolver.getRequestedView("reservationAdministration");
    }

    @GetMapping("/reservation")
    public String reservationPage() {
        System.out.println("Here is inside reservation page!");
        return "reservation";
    }
}
