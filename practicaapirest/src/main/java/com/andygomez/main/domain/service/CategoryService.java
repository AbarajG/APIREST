package com.andygomez.main.domain.service;

import com.andygomez.main.common.dto.CategoryDto;
import com.andygomez.main.domain.entity.Category;

import java.util.List;

public interface CategoryService{

    List<Category> findAllCategories();
    Category findCategoryById(Short id);
    Category createCategory(CategoryDto categoryDto);
    Category updateCategory(CategoryDto categoryDto);
    void deleteCategoryById(Short id);

}
