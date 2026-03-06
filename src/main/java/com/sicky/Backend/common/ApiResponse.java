package com.sicky.Backend.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private boolean status;
    private String message;
    private T data;

    public static <T> ApiResponse<T> successResponse(String message,T data){
            return new ApiResponse<>(true,message,data);
    }

    public static <T> ApiResponse<T> successResponse(String message){
        return new ApiResponse<>(true,message,null);
    }

    public static <T> ApiResponse<T> failedResponse(String message){
        return new ApiResponse<>(false,message,null);
    }

}
