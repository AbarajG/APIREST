package com.andygomez.main.web.controller;

import com.andygomez.main.common.dto.ProductDto;
import com.andygomez.main.domain.entity.Product;
import com.andygomez.main.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.findProductById(id),HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.updateProduct(productDto), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") Long id, @RequestBody BigDecimal price){
        return new ResponseEntity<>(productService.updateProductPriceById(id, price), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable ("id") Long id){
        productService.disableProductById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
