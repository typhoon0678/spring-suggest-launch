package com.typhoon0678.springsuggestlaunch.service;

import com.typhoon0678.springsuggestlaunch.domain.Restaurant;
import com.typhoon0678.springsuggestlaunch.dto.AddRestaurantRequest;
import com.typhoon0678.springsuggestlaunch.dto.UpdateRestaurantRequest;
import com.typhoon0678.springsuggestlaunch.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant save(AddRestaurantRequest request) {
        return restaurantRepository.save(request.toEntity());
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("not found: " + id));
    }

    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Transactional
    public Restaurant update(Long id, UpdateRestaurantRequest request) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("not found: " + id));

        restaurant.update(request.getName(), request.getLat(), request.getCategory(), request.getLon(), LocalDateTime.now());

        return restaurant;
    }
}
