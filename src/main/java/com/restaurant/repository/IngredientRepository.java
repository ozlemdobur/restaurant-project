package com.restaurant.repository;

import com.restaurant.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
  //  public List<Ingredient> getIngredientsByMenuId(Long menuId);

    //List<Ingredient> findIngredientsUsingMenuId();

/*    @Query(value = "SELECT count(status) FROM Visitor where status = :status")
    public Long count(@Param("status") String status);*/

    @Query(value = "select ing from Ingredient ing where menu_Id is not null and menu_Id=:menu_Id")
    public List<Ingredient> getIngredientsByMenuId(@Param("menu_Id") Long menu_Id);

    @Modifying
    @Transactional
    @Query(value = "update Ingredient set menu_Id=:menu_Id where id=:id")
    public void saveMenuIdIntoIngredient(@Param("menu_Id") Long menu_Id, @Param("id") Long id);

/*    @Modifying
    @Transactional
    @Query(value = "update Ingredient set ingAmount=:ingAmount where id=:id")
    public void editIngAmountIntoIngredient(@Param("id") Long id, @Param("ingAmount") Double ingAmount);*/
}
