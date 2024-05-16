package com.typhoon0678.springsuggestlaunch.dto.restaurant;

import com.typhoon0678.springsuggestlaunch.domain.Restaurant;
import lombok.Getter;

@Getter
public class RestaurantResponse {

    private final String name;
    private final Double lat;
    private final Double lon;
    private final Long categoryID;

    public RestaurantResponse(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.lat = restaurant.getLat();
        this.lon = restaurant.getLon();
        this.categoryID = restaurant.getCategory().getId();
    }
}
