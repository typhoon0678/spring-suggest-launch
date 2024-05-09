package com.typhoon0678.springsuggestlaunch.controller;

import com.typhoon0678.springsuggestlaunch.domain.Restaurant;
import com.typhoon0678.springsuggestlaunch.dto.CategoryListViewResponse;
import com.typhoon0678.springsuggestlaunch.dto.RestaurantListViewResponse;
import com.typhoon0678.springsuggestlaunch.dto.RestaurantViewResponse;
import com.typhoon0678.springsuggestlaunch.service.CategoryService;
import com.typhoon0678.springsuggestlaunch.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RestaurantViewController {

    private final RestaurantService restaurantService;
    private final CategoryService categoryService;

    @GetMapping("/restaurants")
    public String getRestaurants(Model model) {
        List<RestaurantListViewResponse> restaurants =
                restaurantService.findAll().stream()
                        .map(RestaurantListViewResponse::new)
                        .toList();

        List<CategoryListViewResponse> categories =
                categoryService.findAll().stream()
                        .map(CategoryListViewResponse::new)
                        .toList();

        model.addAttribute("restaurants", restaurants);
        model.addAttribute("categories", categories);

        return "restaurantList";
    }

    @GetMapping("/restaurants/{id}")
    public String getRestaurant(@PathVariable Long id, Model model) {
        Restaurant restaurant = restaurantService.findById(id);
        model.addAttribute("restaurant", new RestaurantViewResponse(restaurant));

        return "restaurant";
    }

    @GetMapping("/new-restaurant")
    public String newRestaurant(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("restaurant", new RestaurantViewResponse());
        } else {
            Restaurant restaurant = restaurantService.findById(id);
            model.addAttribute("restaurant", new RestaurantViewResponse(restaurant));
        }

        return "newRestaurant";
    }
}
