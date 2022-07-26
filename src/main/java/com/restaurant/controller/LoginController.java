package com.restaurant.controller;

import com.restaurant.authorization.Session;
import com.restaurant.authorization.ViewResolver;
import com.restaurant.model.Personnel;
import com.restaurant.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class LoginController {

    private LoginService loginService;

    public LoginController() {
    }

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

//    @GetMapping(value = "/login/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Personnel> login(@PathVariable String username,@PathVariable String password){
//        System.out.println(username);
//        System.out.println(password);
//        Personnel personnel = loginService.login(username, password);
//        return ResponseEntity.ok(personnel);
//    }

    @GetMapping(value = "/login/{username}/{password}")
    public ResponseEntity<String> login(@PathVariable String username,@PathVariable String password){
        Personnel personnel = loginService.login(username, password);
        Session.createSession(personnel);
        System.out.println(ViewResolver.getMainView());
        return ResponseEntity.ok(ViewResolver.getMainView());
    }

    // Used by front-end to show menu items for role
    @GetMapping(value = "/getrole")
    public String getRole() {
        System.out.println("Inside 'getRole'");
        return Session.getRole();
    }

}
