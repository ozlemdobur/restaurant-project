package com.restaurant.controller;

import com.restaurant.model.Menu;
import com.restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class MenuController {
    private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Menu>> getAllMenus() {
        Iterable<Menu> menus = menuService.findAll();
        System.out.println(menus.toString());
        return ResponseEntity.ok(menus);
    }

    @GetMapping(value = "/menu/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Menu>> getMenuById(@PathVariable Long id) {
        Optional<Menu> menu = menuService.findById(id);
        System.out.println(menu.toString());
        return ResponseEntity.ok(menu);
    }

    @PostMapping(value = "/menu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        Menu menuCreated = menuService.createMenu(menu);
        System.out.println(menu.toString());
        return ResponseEntity.ok(menuCreated);

    }


    @DeleteMapping(value = "/menu/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public void deleteMenuBy(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }



/*    @PostMapping(value="/menu/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {

        String fileName = file.getOriginalFilename();
        String filePathName ="C:\\workspace\\home-restaurant-project-18-07-2022\\src\\main\\resources\\static\\img\\menuPicture\\" + fileName;
        String imagePath ="\\img\\menuPicture\\" + fileName;
        try {

            file.transferTo(new File(filePathName));
            menuService.uploadPictureToMenu(imagePath,id);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("File uploaded successfully.");
    }*/

}