package com.example.ClutchApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClutchApi.business.abstracts.UsersService;
import com.example.ClutchApi.core.request.CreateUserRequest;
import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.CreateUserResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
@NoArgsConstructor
public class UsersController {
    @Autowired
    private UsersService usersService;


   @PostMapping("/createUser")
    public ResponseEntity<ApiResponse<CreateUserResponse>> createUser(@RequestBody CreateUserRequest createUseRequest) {
        ApiResponse<CreateUserResponse> response = usersService.createUser(createUseRequest);

        if(!response.isSuccess()) {
            
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


   
}
