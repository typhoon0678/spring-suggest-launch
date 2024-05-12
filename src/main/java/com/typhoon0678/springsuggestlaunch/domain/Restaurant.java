package com.typhoon0678.springsuggestlaunch.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @CreatedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Restaurant(String name, Double lat, Double lon, Category category, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void update(String name, Double lat, Category category, Double lon, LocalDateTime updatedAt) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.category = category;
        this.updatedAt = updatedAt;
    }
}
