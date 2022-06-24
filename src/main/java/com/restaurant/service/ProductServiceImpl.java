package com.restaurant.service;

import com.restaurant.model.Product;
import com.restaurant.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        Comparator<Product> sorted = Comparator.comparingDouble(c -> c.getStockAmount() - c.getMinumumLimit());
        //(c1, c2)-> Double.compare(c1.getStockAmount()-c1.getMinumumLimit(),c2.getStockAmount()-c2.getMinumumLimit());
        return productRepository.findAll().stream().sorted(sorted).toList();
    }

    @Override
    public Product createProduct(Product product) {
        Product productCreated = productRepository.save(product);
        return productCreated;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getBiggerAmount(Long stockAmount) {
        return productRepository.findByStockAmountGreaterThan(stockAmount);
    }

}
