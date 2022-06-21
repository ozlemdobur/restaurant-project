package com.restaurant.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Menu {  @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
    private String name;
    private String description;
    private String type;
    private double price;

    public Menu() {
    }

    public Menu(long id, String name, String description, String type, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
