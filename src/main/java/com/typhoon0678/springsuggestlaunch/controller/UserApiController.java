package com.typhoon0678.springsuggestlaunch.controller;

import com.typhoon0678.springsuggestlaunch.dto.AddUserRequest;

import com.typhoon0678.springsuggestlaunch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final Logger log = LoggerFactory.getLogger((this.getClass().getSimpleName()));
    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        log.warn(request.getUsername());
        userService.save(request);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
