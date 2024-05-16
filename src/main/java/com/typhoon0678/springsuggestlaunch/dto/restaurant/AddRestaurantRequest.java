package com.typhoon0678.springsuggestlaunch.dto.restaurant;

import com.typhoon0678.springsuggestlaunch.domain.Category;
import com.typhoon0678.springsuggestlaunch.domain.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddRestaurantRequest {

    private String name;
    private Double lat;
    private Double lon;
    private Long categoryId;

    public Restaurant toEntity(Category category) {

        return Restaurant.builder()
                .name(name)
                .lat(lat)
                .lon(lon)
                .category(category)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
