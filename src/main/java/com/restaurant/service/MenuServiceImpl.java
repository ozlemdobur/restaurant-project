package com.restaurant.service;

import com.restaurant.model.Ingredient;
import com.restaurant.model.Menu;
import com.restaurant.repository.IngredientRepository;
import com.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    private MenuRepository menuRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    @Override
    public Iterable<Menu> findAll() {
        Iterable<Menu> menu = menuRepository.findAll();
        return menu;
    }

    @Override
    public Menu createMenu(Menu menu) {
        Menu menuCreated;
        if (menu.getId() != null) {
            List<Ingredient> ingredientList = ingredientRepository.getIngredientsByMenuId(menu.getId());
            menuCreated = menuRepository.save(menu);
            for (Ingredient ingList : ingredientList) {
                ingredientRepository.saveMenuIdIntoIngredient(menu.getId(), ingList.getId());
            }
        } else {

            menuCreated = menuRepository.save(menu);
        }
        return menuCreated;
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

/*    @Override
    public void uploadPictureToMenu(String imagePath, Long id) {
        menuRepository.uploadPictureToMenu(imagePath,id);
    }*/


    @Override
    public Optional<Menu> findById(Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        return menu;
    }


}
