package com.typhoon0678.springsuggestlaunch.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String email;
    private String password;
}
