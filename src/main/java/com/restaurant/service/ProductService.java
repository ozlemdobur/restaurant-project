package com.restaurant.service;


import com.restaurant.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getBiggerAmount(Long stockAmount);
    Iterable<Product> findAll();
    Product createProduct(Product product);
    void deleteProduct(Long id);
    Optional<Product> findByProduct(Long id);
}
