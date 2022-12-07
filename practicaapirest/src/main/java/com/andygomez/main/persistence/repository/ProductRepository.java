package com.andygomez.main.persistence.repository;

import com.andygomez.main.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findProductByIdAndDeleted(Long id, Boolean deleted);

}
