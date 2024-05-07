package com.typhoon0678.springsuggestlaunch.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @CreatedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Restaurant(String name, Double lat, Double lon, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void update(String name, Double lat, Double lon, LocalDateTime updatedAt) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.updatedAt = updatedAt;
    }
}
