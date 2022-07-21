package com.restaurant.service;

import com.restaurant.model.Ingredient;

import java.util.List;


public interface IngredientService {
    List<Ingredient> findAll();
    Ingredient createIngredient(Ingredient ingredient);
    void deleteIngredient(Long id);
    List<Ingredient> getIngredientsByMenuId(Long menuId);
   // void editIngAmountIntoIngredient(Long id, Double ingAmount);
    void saveMenuIdIntoIngredient(Long menuId, Long id);
    //Iterable<Ingredient> findIngsUsingMenuId(Long menuId);
}
