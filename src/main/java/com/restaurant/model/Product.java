package com.restaurant.model;

import javax.persistence.*;

@Entity()
@Table(name="product")
public class Product {
    @Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private String measurementUnit;
    private Double stockAmount;
    private Double minumumLimit;
    private String supplier;
    private String brand;
    private Double price;
    private Double unitPrice;

    public Product(Long id, String productName, String measurementUnit, Double stockAmount, Double minumumLimit, String supplier) {
        this.id = id;
        this.productName = productName;
        this.measurementUnit = measurementUnit;
        this.stockAmount = stockAmount;
        this.minumumLimit = minumumLimit;
        this.supplier = supplier;
    }

    public Product() {
    }

    public Product(Long id, String productName, String measurementUnit, Double stockAmount, Double minumumLimit, String supplier, String brand, Double price, Double unitPrice) {
        this.id = id;
        this.productName = productName;
        this.measurementUnit = measurementUnit;
        this.stockAmount = stockAmount;
        this.minumumLimit = minumumLimit;
        this.supplier = supplier;
        this.brand = brand;
        this.price = price;
        this.unitPrice = unitPrice;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}