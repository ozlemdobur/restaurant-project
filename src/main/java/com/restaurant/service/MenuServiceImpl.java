package com.restaurant.service;

import com.restaurant.model.Menu;
import com.restaurant.repository.MenuRepository;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Optional<Menu> getMenuById(long id) {
        return menuRepository.findById(id);
    }

    @Override
    public List<Menu> findAllMenu() {
        Iterable<Menu> menuIterable = menuRepository.findAll();
        List<Menu> menuList = new ArrayList<>();
        menuIterable.forEach(menuList::add);
        return menuList;
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

//    @Override
//    public Menu updateMenu(Menu menu) {
//        Optional<Menu> menuOptional = menuRepository.findById(menu.getId());
//        if (menuOptional.isEmpty()) throw new NotFoundException();
//        menuOptional.get().setName(menu.getName());
//        menuOptional.get().setPrice(menu.getPrice());
//        menuOptional.get().setDescription(menu.getDescription());
//        menuOptional.get().setType(menu.getType());
//        menuRepository.save(menuOptional.get());
//        return menuOptional.get();
//    }

    @Override
    public void deleteMenu(long id) {
        menuRepository.deleteById(id);
    }
}
