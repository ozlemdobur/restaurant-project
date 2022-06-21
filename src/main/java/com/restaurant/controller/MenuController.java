package com.restaurant.controller;

import com.restaurant.model.Menu;
//import com.restaurant.exception.NotFoundException;
import com.restaurant.service.MenuService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/menu")
public class MenuController { @Autowired
MenuService menuService;
    private Menu willUpdateMenu;

//    @GetMapping("/{id}")
//    public ResponseEntity<Menu> getMenuById(@PathVariable long id) {
//        Optional<Menu> menuOptional = menuService.getMenuById(id);
//        if (menuOptional.isEmpty())
//            throw new NotFoundException();
//        return new ResponseEntity<>(menuOptional.get(), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenu() {
        return new ResponseEntity<>(menuService.findAllMenu(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        return new ResponseEntity<>(menuService.save(menu), HttpStatus.OK);
    }

//    @PutMapping
//    public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu) {
//        return new ResponseEntity<>(menuService.updateMenu(menu), HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable long id) {
        menuService.deleteMenu(id);
    }

    @PutMapping(value = "/willupdatemenu")
    public void willUpdateMenu(@RequestBody Menu menu) {
        willUpdateMenu = menu;
    }

    @GetMapping("/update")
    public ResponseEntity<Menu> getWillUpdateMenu() {
        return new ResponseEntity<>(willUpdateMenu, HttpStatus.OK);
    }
}
