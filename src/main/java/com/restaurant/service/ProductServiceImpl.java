package com.restaurant.service;

import com.restaurant.model.Product;
import com.restaurant.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }


    @Override
    public Product update(Product product) {
        Product prd = findById(product.getId());
        prd.setProductName(product.getProductName());
        prd.setMeasurementUnit(product.getMeasurementUnit());
        prd.setNewAmount(product.getNewAmount());
        prd.setStockAmount(product.getStockAmount());
        prd.setSupplierEmail(product.getSupplierEmail());
        return productRepository.save(prd);
    }

    @Override
    public void delete(Long id) {
        Product prd = findById(id);
        productRepository.delete(prd);
    }

    @Override
    public Iterable<Product> list() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getBiggerAmount(Long stockAmount) {
        return productRepository.findByStockAmountGreaterThan(stockAmount);
    }
}
