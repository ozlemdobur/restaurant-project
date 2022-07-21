package com.restaurant.service;

import com.restaurant.model.Ingredient;
import com.restaurant.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService{

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAll() {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();
        return ingredients;
    }

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        Ingredient ingredientCreated = ingredientRepository.save(ingredient);
        return ingredientCreated;
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public List<Ingredient> getIngredientsByMenuId(Long menuId) {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.getIngredientsByMenuId(menuId);
        return ingredients;
    }

    @Override
    public void saveMenuIdIntoIngredient(Long menuId, Long id) {
        ingredientRepository.saveMenuIdIntoIngredient(menuId, id);
    }

/*    @Override
    public List<Ingredient> findIngsUsingMenuId(Long menuId) {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findIngsUsingMenuId(menuId);
        return ingredients;
    }*/

}
