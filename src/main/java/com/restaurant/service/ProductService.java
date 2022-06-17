package com.restaurant.service;


import com.restaurant.model.Product;

import java.util.List;

public interface ProductService {

    Product findById(Long id);

    Product add(Product product);

    Product update(Product product);

    void delete(Long id);

    Iterable<Product> list();

    List<Product> getBiggerAmount(Long stockAmount);
}
