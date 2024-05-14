package com.typhoon0678.springsuggestlaunch.repository;

import com.typhoon0678.springsuggestlaunch.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
