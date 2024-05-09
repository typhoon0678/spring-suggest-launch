package com.typhoon0678.springsuggestlaunch.service;

import com.typhoon0678.springsuggestlaunch.domain.Category;
import com.typhoon0678.springsuggestlaunch.dto.AddCategoryRequest;
import com.typhoon0678.springsuggestlaunch.dto.UpdateCategoryRequest;
import com.typhoon0678.springsuggestlaunch.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category save(AddCategoryRequest request) {
        return categoryRepository.save(request.toEntity());
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("not found: " + id));
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Transactional
    public Category update (Long id, UpdateCategoryRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("not found: " + id));

        category.update(request.getName());

        return category;
    }
}
