package com.sicky.Backend.service;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sicky.Backend.common.ApiResponse;
import com.sicky.Backend.dto.UserSignupRequest;
import com.sicky.Backend.dto.response.UserSignupResponse;
import com.sicky.Backend.entity.User;
import com.sicky.Backend.repository.UserRepository;


@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public ResponseEntity<ApiResponse<UserSignupResponse>> signup(UserSignupRequest usersSignupRequest){

        if(!usersSignupRequest.getPassword().equals(usersSignupRequest.getConfirmPassword())){
            return ResponseEntity.badRequest().body(ApiResponse.failedResponse("Password doesnt match"));
        }

        String phoneNumer = usersSignupRequest.getPhoneNumber();

        User user = userRepository.findByPhoneNumber(phoneNumer);

        if(user == null){
            User newUser = User.builder()
                        .userId(UUID.randomUUID())
                        .fullName(usersSignupRequest.getFullName())
                        .password(usersSignupRequest.getPassword())
                        .phoneNumber(usersSignupRequest.getPhoneNumber())
                        .isActive(false)
                        .isDeleted(false)
                        .isSignupConfirmed(false)
                        .isPhoneverified(false)
                        .build();

            userRepository.save(newUser);

             //otp service
            UserSignupResponse response = new UserSignupResponse();
            return ResponseEntity.ok().body(ApiResponse.successResponse("User registered successfully", response));
        }else{
            if(user.isPhoneverified()){
                return ResponseEntity.badRequest().body(ApiResponse.failedResponse("Phone number already exists"));
            }else{
                user.setFullName(usersSignupRequest.getFullName());
                user.setPassword(usersSignupRequest.getPassword());
                userRepository.save(user);
                UserSignupResponse response = new UserSignupResponse();
                return ResponseEntity.ok().body(ApiResponse.successResponse("User registered successfully", response));
            }
        }
                    
    }

}
