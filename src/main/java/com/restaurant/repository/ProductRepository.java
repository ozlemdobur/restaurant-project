package com.restaurant.repository;

import com.restaurant.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    //@Query("select p from Product p where p.stockAmount>")

    List<Product> findByStockAmountGreaterThan(Long amount);
}
