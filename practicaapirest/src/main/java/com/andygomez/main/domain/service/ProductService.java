package com.andygomez.main.domain.service;

import com.andygomez.main.common.dto.ProductDto;
import com.andygomez.main.domain.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();
    Product findProductById(Long id);
    Product createProduct(ProductDto productDto);
    Product updateProduct(ProductDto productDto);
    Product updateProductPriceById(Long id, BigDecimal price);
    void disableProductById(Long id);

}
