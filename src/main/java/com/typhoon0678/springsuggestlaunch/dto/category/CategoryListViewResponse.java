package com.typhoon0678.springsuggestlaunch.dto.category;

import com.typhoon0678.springsuggestlaunch.domain.Category;
import lombok.Getter;

@Getter
public class CategoryListViewResponse {

    private final Long id;
    private final String name;

    public CategoryListViewResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
