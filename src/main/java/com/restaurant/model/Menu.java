package com.restaurant.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String menuName;
    private BigDecimal price;
    private String menuType;
    private String imagePath;
    @OneToMany
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
   // @JoinTable(name = "MENU_INGREDIENTS")
    private Set<Ingredient> ingredients;

    public Menu() {
    }

/*    public Menu(Long id, Set<Ingredient> ingredients) {
        this.id = id;
        this.ingredients = ingredients;
    }*/

    public Menu(Long id, String menuName, BigDecimal price, String menuType, String imagePath, Set<Ingredient> ingredients) {
        this.id = id;
        this.menuName = menuName;
        this.price = price;
        this.menuType = menuType;
        this.imagePath = imagePath;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", price=" + price +
                ", menuType='" + menuType + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}