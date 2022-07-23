package com.restaurant.service;

import com.restaurant.model.Menu;
import com.restaurant.output.MenuOutput;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    Iterable<Menu> findAll();
    Menu createMenu(Menu menu);
    void deleteMenu(Long Id);
    void uploadPictureToMenu(String imagePath, Long id);
    Optional<Menu> findById(Long id);
    List<MenuOutput> findByMenuTypeLike(String menuType);
}
