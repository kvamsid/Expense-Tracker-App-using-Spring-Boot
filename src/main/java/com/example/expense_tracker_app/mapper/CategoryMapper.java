package com.example.expense_tracker_app.mapper;

import com.example.expense_tracker_app.dto.CategoryDto;
import com.example.expense_tracker_app.entity.Category;

public class CategoryMapper {

    public static CategoryDto maptoCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto(category.getId(), category.getName());
        return categoryDto;
    }

    public static Category maptoCategory(CategoryDto categoryDto) {
        Category category = new Category(categoryDto.id(), categoryDto.name());
        return category;
    }

}
