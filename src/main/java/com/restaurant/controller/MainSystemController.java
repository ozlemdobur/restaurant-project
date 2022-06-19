package com.restaurant.controller;

import com.restaurant.model.Personnel;
import com.restaurant.service.LoginService;
import com.restaurant.service.MainSystemService;
import com.restaurant.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class MainSystemController {
    private MainSystemService mainSystemService;

    @Autowired
    public MainSystemController(MainSystemService mainSystemService) {
        this.mainSystemService = mainSystemService;
    }


    @GetMapping(value="/mainsystem/{username}")
    public ResponseEntity<Personnel> getUser(@PathVariable String username){
        Personnel personnel = mainSystemService.getUser(username);
        System.out.println("kullaniici" + personnel.getRole());
        return ResponseEntity.ok(personnel);
    }

}
