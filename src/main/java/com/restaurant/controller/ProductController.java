package com.restaurant.controller;

import com.restaurant.model.Product;
import com.restaurant.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    ProductService productService;/**/

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        Product product1 = productService.add(product);
        return ResponseEntity.ok(product1);

    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product product1 = productService.update(product);
        return ResponseEntity.ok(product1);
    }

    @GetMapping("/stockamount/{stockAmount}")
    public ResponseEntity<Iterable<Product>> getBiggerAmountList(@PathVariable Long stockAmount){
        return ResponseEntity.ok(productService.getBiggerAmount(stockAmount));
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> listProduct(){
        return ResponseEntity.ok(productService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findByIdProduct(@PathVariable Long id){
        Product product1 = productService.findById(id);
        return ResponseEntity.ok(product1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return  ResponseEntity.ok(null);
    }
}
