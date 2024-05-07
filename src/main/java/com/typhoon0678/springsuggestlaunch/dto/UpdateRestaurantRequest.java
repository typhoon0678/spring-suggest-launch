package com.typhoon0678.springsuggestlaunch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateRestaurantRequest {
    private String name;
    private Double lat;
    private Double lon;
    private LocalDateTime updatedAt;
}
