package com.sicky.Backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicky.Backend.common.ApiResponse;
import com.sicky.Backend.dto.UserSignupRequest;
import com.sicky.Backend.dto.response.UserSignupResponse;
import com.sicky.Backend.service.AuthService;


@RestController
public class AuthController {

    public AuthService authService;

    @GetMapping("greeting")
    public String greeting(){
        return "Welcome";
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserSignupResponse>> userSignup(@RequestBody UserSignupRequest userSignupRequest){   
        return authService.signup(userSignupRequest);
    }



}
