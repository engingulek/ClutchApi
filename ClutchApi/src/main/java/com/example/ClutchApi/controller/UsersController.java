package com.example.ClutchApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClutchApi.business.abstracts.UsersService;
import com.example.ClutchApi.core.request.LoginRequest;
import com.example.ClutchApi.core.request.UserRequest;
import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.entities.Users;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
@NoArgsConstructor
public class UsersController {
    @Autowired
    private UsersService usersService;


   @PostMapping("/signup")
    public ResponseEntity<ApiResponse<Users>> signUp(@RequestBody UserRequest userRequest) {
        ApiResponse<Users> response = usersService.createUser(userRequest);

        if(!response.isSuccess()) {
            
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


     @PostMapping("/login")
    public ResponseEntity<ApiResponse<Users>> login(@RequestBody LoginRequest loginRequest) {
        ApiResponse<Users> response = usersService.login(loginRequest);

        if(response.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
