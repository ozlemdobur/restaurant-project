package com.restaurant.service;

import com.restaurant.model.Menu;

import java.util.Optional;

public interface MenuService {
    Iterable<Menu> findAll();
    Menu createMenu(Menu menu);
    void deleteMenu(Long Id);
    //void uploadPictureToMenu(String imagePath, Long id);
    Optional<Menu> findById(Long id);
}
