package com.typhoon0678.springsuggestlaunch.dto;

import com.typhoon0678.springsuggestlaunch.domain.Category;
import lombok.Getter;

@Getter
public class CategoryResponse {

    private final String name;

    public CategoryResponse(Category category) {
        this.name = category.getName();
    }
}
