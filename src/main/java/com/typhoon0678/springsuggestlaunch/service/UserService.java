package com.typhoon0678.springsuggestlaunch.service;

import com.typhoon0678.springsuggestlaunch.domain.User;
import com.typhoon0678.springsuggestlaunch.dto.AddUserRequest;
import com.typhoon0678.springsuggestlaunch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build()).getId();
    }
}
