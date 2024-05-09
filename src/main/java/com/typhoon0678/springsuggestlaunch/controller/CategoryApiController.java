package com.typhoon0678.springsuggestlaunch.controller;

import com.typhoon0678.springsuggestlaunch.domain.Category;
import com.typhoon0678.springsuggestlaunch.dto.AddCategoryRequest;
import com.typhoon0678.springsuggestlaunch.dto.CategoryResponse;
import com.typhoon0678.springsuggestlaunch.dto.UpdateCategoryRequest;
import com.typhoon0678.springsuggestlaunch.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/categories")
public class CategoryApiController {

    private final CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<Category> addCategory(@RequestBody AddCategoryRequest request) {
        Category savedCategory = categoryService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.findAll()
                .stream()
                .map(CategoryResponse::new)
                .toList();

        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id);

        return ResponseEntity.ok().body(new CategoryResponse(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody UpdateCategoryRequest request) {
        Category updatedCategory = categoryService.update(id, request);

        return ResponseEntity.ok().body(updatedCategory);
    }
}
