package com.typhoon0678.springsuggestlaunch.service;

import com.typhoon0678.springsuggestlaunch.domain.Category;
import com.typhoon0678.springsuggestlaunch.domain.Restaurant;
import com.typhoon0678.springsuggestlaunch.dto.AddRestaurantRequest;
import com.typhoon0678.springsuggestlaunch.dto.UpdateRestaurantRequest;
import com.typhoon0678.springsuggestlaunch.repository.CategoryRepository;
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
    private final CategoryRepository categoryRepository;

    public Restaurant save(AddRestaurantRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() ->
                new IllegalArgumentException("Category not found"));

        return restaurantRepository.save(request.toEntity(category));
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

        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() ->
                new IllegalArgumentException("not found Category: " + request.getCategoryId()));

        restaurant.update(request.getName(), request.getLat(), category, request.getLon(), LocalDateTime.now());

        return restaurant;
    }
}
