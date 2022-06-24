package com.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private String measurementUnit;
    private Double stockAmount;
        private Double minumumLimit;
    private String supplier;

    public Product() {
    }

    public Product(Long id, String productName, String measurementUnit, Double stockAmount, Double minumumLimit, String supplierEmail) {
        this.id = id;
        this.productName = productName;
        this.measurementUnit = measurementUnit;
        this.stockAmount = stockAmount;
        this.minumumLimit = minumumLimit;
        this.supplier = supplierEmail;
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

    public Double getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Double stockAmount) {
        this.stockAmount = stockAmount;
    }

    public Double getMinumumLimit() {
        return minumumLimit;
    }

    public void setMinumumLimit(Double minumumLimit) {
        this.minumumLimit = minumumLimit;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", measurementUnit='" + measurementUnit + '\'' +
                ", stockAmount=" + stockAmount +
                ", minumumLimit=" + minumumLimit +
                ", supplier='" + supplier + '\'' +
                '}';
    }
}