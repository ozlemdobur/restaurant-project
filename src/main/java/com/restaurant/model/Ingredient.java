package com.restaurant.model;

import javax.persistence.*;

@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ingredient_id")
    private Long id;
    private Double ingAmount;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Ingredient(Long id, Double ingAmount, Product product) {
        this.id = id;
        this.ingAmount = ingAmount;
        this.product = product;
    }

    /*   public Ingredient(Long id, Menu menu, Double ingredientAmount, Product product) {
            this.id = id;
            this.menu = menu;
            this.ingredientAmount = ingredientAmount;
            this.product = product;
        }
    */
    public Ingredient() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

/*    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }*/

   public Product getproduct() {
        return product;
    }

    public void setproduct(Product product) {
        this.product = product;
    }

    public Double getIngAmount() {
        return ingAmount;
    }

    public void setIngAmount(Double ingAmount) {
        this.ingAmount = ingAmount;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
              //  ", menu=" + menu +
                ", ingredientAmount=" + ingAmount +
                ", product=" + product +
                '}';
    }
}
