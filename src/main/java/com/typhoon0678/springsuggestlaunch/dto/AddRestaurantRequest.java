package com.typhoon0678.springsuggestlaunch.dto;

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

    public Restaurant toEntity() {
        return Restaurant.builder()
                .name(name)
                .lat(lat)
                .lon(lon)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
