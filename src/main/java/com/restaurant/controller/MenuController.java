package com.restaurant.controller;

import com.restaurant.model.Menu;
import com.restaurant.output.MenuOutput;
import com.restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class MenuController {

    @Value("${file.image-dir}")
    private String imageDir;

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

    @GetMapping(value = "/menu/menuType/{menuType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MenuOutput>> getAllByMenuType(@PathVariable String menuType) {
        List<MenuOutput> menus = menuService.findByMenuTypeLike(menuType);
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


    @PostMapping(value = "/menu/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {

        String fileName = file.getOriginalFilename();
        Optional<Menu> menu= menuService.findById(id);
        //String fileName =menu.get().getMenuName()+".png";
        String filePathName = imageDir + fileName;

        try {

            file.transferTo(new File(filePathName));
            menuService.uploadPictureToMenu(fileName, id);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("File uploaded successfully.");
    }



    @GetMapping(value = "/menu/getImage/{fileName}")
    public Resource showImage(@PathVariable String fileName) throws Exception {
        try {
            Path fileStorageLocation = Paths.get(imageDir)
                    .toAbsolutePath().normalize();
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new Exception("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new Exception("File not found " + fileName, ex);
        }
    }

    public BufferedImage loadImage(String path) throws IOException {
        System.out.println(getClass());
        BufferedImage image = ImageIO.read(new FileInputStream(path));
        return image;
    }


}