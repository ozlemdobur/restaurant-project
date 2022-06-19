package com.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String productName;
    private String measurementUnit;
    private Long newAmount;
    private long stockAmount;
    private String supplierEmail;

    public Product() {
    }

    public Product(Long id, String productName, String measurementUnit, Long newAmount, long stockAmount, String supplierEmail) {
        this.id = id;
        this.productName = productName;
        this.measurementUnit = measurementUnit;
        this.newAmount = newAmount;
        this.stockAmount = stockAmount;
        this.supplierEmail = supplierEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Long getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(Long newAmount) {
        this.newAmount = newAmount;
    }

    public long getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(long stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }
}
