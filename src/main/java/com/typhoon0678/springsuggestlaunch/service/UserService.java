package com.typhoon0678.springsuggestlaunch.service;

import com.typhoon0678.springsuggestlaunch.domain.User;
import com.typhoon0678.springsuggestlaunch.dto.user.AddUserRequest;
import com.typhoon0678.springsuggestlaunch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long save(AddUserRequest dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .createdAt(LocalDateTime.now())
                .build()).getId();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("User with id " + id + " not found"));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
