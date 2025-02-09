package com.example.expense_tracker_app.service.impl;

import com.example.expense_tracker_app.dto.CategoryDto;
import com.example.expense_tracker_app.entity.Category;
import com.example.expense_tracker_app.exceptions.ResourceNotFoundException;
import com.example.expense_tracker_app.mapper.CategoryMapper;
import com.example.expense_tracker_app.repository.CategoryRepository;
import com.example.expense_tracker_app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.maptoCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.maptoCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category not found with id: "+id));
        return CategoryMapper.maptoCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categories.forEach(category -> categoryDtos.add(CategoryMapper.maptoCategoryDto(category)));
        return categoryDtos;
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category not found with id: "+id));
        category.setName(categoryDto.name());
        return CategoryMapper.maptoCategoryDto(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category not found with id: "+id));
        categoryRepository.delete(category);
    }
}
