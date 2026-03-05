package com.sicky.Backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("greeting")
    public String greeting(){
        return "Welcome";
    }

    public void userSignup(){
        
    }



}
