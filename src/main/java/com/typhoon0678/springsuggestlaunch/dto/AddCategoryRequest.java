package com.typhoon0678.springsuggestlaunch.dto;

import com.typhoon0678.springsuggestlaunch.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCategoryRequest {

    private String name;

    public Category toEntity() {
        return Category.builder()
                .name(name)
                .build();
    }
}
