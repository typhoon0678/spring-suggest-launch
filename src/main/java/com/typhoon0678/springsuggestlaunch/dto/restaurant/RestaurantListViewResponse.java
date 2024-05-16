package com.typhoon0678.springsuggestlaunch.dto.restaurant;

import com.typhoon0678.springsuggestlaunch.domain.Restaurant;
import lombok.Getter;

@Getter
public class RestaurantListViewResponse {

    private final Long id;
    private final String name;
    private final Double lat;
    private final Double lon;
    private final Long categoryId;

    public RestaurantListViewResponse(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.lat = restaurant.getLat();
        this.lon = restaurant.getLon();
        this.categoryId = restaurant.getCategory().getId();
    }
}
