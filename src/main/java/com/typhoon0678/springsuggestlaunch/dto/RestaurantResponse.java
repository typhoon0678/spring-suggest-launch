package com.typhoon0678.springsuggestlaunch.dto;

import com.typhoon0678.springsuggestlaunch.domain.Restaurant;
import lombok.Getter;

@Getter
public class RestaurantResponse {

    private final String name;
    private final Double lat;
    private final Double lon;

    public RestaurantResponse(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.lat = restaurant.getLat();
        this.lon = restaurant.getLon();
    }
}
