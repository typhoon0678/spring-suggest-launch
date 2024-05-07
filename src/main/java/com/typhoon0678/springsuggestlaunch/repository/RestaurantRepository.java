package com.typhoon0678.springsuggestlaunch.repository;

import com.typhoon0678.springsuggestlaunch.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
