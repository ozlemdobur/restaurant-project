package com.restaurant.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainSystemMvcController {

 /*   @DeleteMapping(value = "/customer", produces= MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteCustomerByIdParam( @RequestParam Long customerId){
        System.out.println("Inside deleteCustomerById");
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok( "Customer with id: " + customerId + " is deleted");*/

        @GetMapping("/mainsystem")
        public String getLoginPage(@RequestParam String username) {
            System.out.println(username);
            return "mainsystem";
        }


/*    @GetMapping("/mainsystem/{username}")
    public String getLoginPage(@PathVariable String username) {
        System.out.println(username);
        return "mainsystem";
    }*/
}
