package com.sicky.Backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupRequest {
    private String fullName;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
}
