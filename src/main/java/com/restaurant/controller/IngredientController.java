package com.restaurant.controller;

import com.restaurant.model.Ingredient;
import com.restaurant.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class IngredientController {

    private IngredientService ingredientService;
    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(value = "/ingredient", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ingredient>> getAllIngredients(){
        List<Ingredient> ingredients = ingredientService.findAll();
        System.out.println(ingredients.toString());
        return ResponseEntity.ok(ingredients);
    }


    @GetMapping(value = "/ingredient/{menuId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Ingredient>> getAllIngredientsByMenuId(@PathVariable Long menuId){
        Iterable<Ingredient> ingredients = ingredientService.getIngredientsByMenuId(menuId);
        System.out.println(ingredients.toString());
        return ResponseEntity.ok(ingredients);
    }


    @PostMapping(value = "/ingredient",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient){
        Ingredient ingredientCreated = ingredientService.createIngredient(ingredient);
        return ResponseEntity.ok(ingredientCreated);
    }

    @GetMapping(value = "/ingredient/{menuId}/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveMenuIdIntoIngredient(@PathVariable Long menuId, @PathVariable Long id){
        ingredientService.saveMenuIdIntoIngredient(menuId, id);

    }


    @DeleteMapping(value="/ingredient/{id}",produces = MediaType.TEXT_PLAIN_VALUE)
    public void deleteIngredient(@PathVariable Long id){
        ingredientService.deleteIngredient(id);
    }

}
