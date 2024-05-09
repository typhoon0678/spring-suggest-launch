package com.typhoon0678.springsuggestlaunch.repository;

import com.typhoon0678.springsuggestlaunch.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
