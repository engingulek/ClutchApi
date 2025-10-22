package com.example.ClutchApi.business.abstracts;

import com.example.ClutchApi.core.request.LoginRequest;
import com.example.ClutchApi.core.request.UserRequest;
import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.entities.Users;

public interface UsersService {
    ApiResponse<Users> createUser(UserRequest userRequest);
     ApiResponse<Users> login(LoginRequest loginRequest);
}
