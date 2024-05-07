package com.typhoon0678.springsuggestlaunch.dto;

import com.typhoon0678.springsuggestlaunch.domain.Restaurant;
import lombok.Getter;

@Getter
public class RestaurantListViewResponse {

    private final Long id;
    private final String name;
    private final Double lat;
    private final Double lon;

    public RestaurantListViewResponse(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.lat = restaurant.getLat();
        this.lon = restaurant.getLon();
    }
}
