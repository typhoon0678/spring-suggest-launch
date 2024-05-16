package com.typhoon0678.springsuggestlaunch.dto.category;

import com.typhoon0678.springsuggestlaunch.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CategoryViewResponse {

    private Long id;
    private String name;

    public CategoryViewResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
