package com.restaurant.service;
import com.restaurant.model.Menu;

import java.util.Optional;
import java.util.List;
public interface MenuService {


        Optional<Menu> getMenuById(long id);

        List<Menu> findAllMenu();

        Menu save(Menu menu);

//        Menu updateMenu(Menu menu);

        void deleteMenu(long id);
    }

