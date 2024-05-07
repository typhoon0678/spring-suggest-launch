package com.typhoon0678.springsuggestlaunch.dto;

import com.typhoon0678.springsuggestlaunch.domain.Restaurant;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class RestaurantViewResponse {

    private Long id;
    private String name;
    private Double lat;
    private Double lon;
    private LocalDateTime createdAt;

    public RestaurantViewResponse(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.lat = restaurant.getLat();
        this.lon = restaurant.getLon();
        this.createdAt = restaurant.getCreatedAt();
    }
}
