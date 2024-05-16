package com.typhoon0678.springsuggestlaunch.controller;

import com.typhoon0678.springsuggestlaunch.domain.Restaurant;
import com.typhoon0678.springsuggestlaunch.dto.restaurant.AddRestaurantRequest;
import com.typhoon0678.springsuggestlaunch.dto.restaurant.RestaurantResponse;
import com.typhoon0678.springsuggestlaunch.dto.restaurant.UpdateRestaurantRequest;
import com.typhoon0678.springsuggestlaunch.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/restaurants")
public class RestaurantApiController {

    private final RestaurantService restaurantService;

    @PostMapping("")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody AddRestaurantRequest request) {
        Restaurant savedRestaurant = restaurantService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRestaurant);
    }

    @GetMapping("")
    public ResponseEntity<List<RestaurantResponse>> findAllRestaurants() {
        List<RestaurantResponse> restaurants = restaurantService.findAll()
                .stream()
                .map(RestaurantResponse::new)
                .toList();

        return ResponseEntity.ok().body(restaurants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> findRestaurantById(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.findById(id);

        return ResponseEntity.ok().body(new RestaurantResponse(restaurant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(
            @PathVariable Long id, @RequestBody UpdateRestaurantRequest request) {
        Restaurant updatedRestaurant = restaurantService.update(id, request);

        return ResponseEntity.ok().body(updatedRestaurant);
    }

}
