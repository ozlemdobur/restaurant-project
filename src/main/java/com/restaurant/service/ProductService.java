package com.restaurant.service;


import com.restaurant.model.Personnel;
import com.restaurant.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getBiggerAmount(Long stockAmount);
    Iterable<Product> findAll();
    Product createProduct(Product product);
    void deleteProduct(Long id);
}
