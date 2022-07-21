package com.restaurant.controller;

import com.restaurant.model.Product;
import com.restaurant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        Iterable<Product> products = productService.findAll();
        System.out.println(products.toString());
        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Product>> getAllProducts(@PathVariable Long id) {
        Optional<Product> products = productService.findByProduct(id);
        System.out.println(products.toString());
        return ResponseEntity.ok(products);
    }


    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product productCreated = productService.createProduct(product);
        System.out.println(product.toString());
        return ResponseEntity.ok(productCreated);

    }

    @GetMapping("/stockamount/{stockAmount}")
    public ResponseEntity<Iterable<Product>> getBiggerAmountList(@PathVariable Long stockAmount) {
        return ResponseEntity.ok(productService.getBiggerAmount(stockAmount));
    }

    @DeleteMapping(value = "/product/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public void deleteProductBy(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
