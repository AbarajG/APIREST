package com.andygomez.main.domain.service.impl;

import com.andygomez.main.common.dto.ProductDto;
import com.andygomez.main.domain.entity.Product;
import com.andygomez.main.domain.service.ProductService;
import com.andygomez.main.persistence.repository.ProductRepository;
import com.andygomez.main.domain.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public List<Product> findAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        Product product = productRepository.findProductByIdAndDeleted(id, false);
        if (product == null){
            throw  new EntityNotFoundException("The product with ID: " + id + " is not found");
        }
        return product;
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setCategory(categoryService.findCategoryById(productDto.getCategoryId()));
        BeanUtils.copyProperties(productDto, product);
        product.setDeleted(false);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return productRepository.save(product);
    }

    @Override
    public Product updateProductPriceById(Long id, BigDecimal price) {
        Product product= this.findProductById(id);
        product.setPrice(price.setScale(2 , RoundingMode.HALF_EVEN));
        return productRepository.save(product);
    }

    @Override
    public void disableProductById(Long id) {
        Product product = this.findProductById(id);
        product.setDeleted(true);
        productRepository.save(product);
    }
}
