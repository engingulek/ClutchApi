package com.example.ClutchApi.business.abstracts;


import com.example.ClutchApi.core.request.CreateUserRequest;
import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.CreateUserResponse;

public interface UsersService {
       ApiResponse<CreateUserResponse> createUser(CreateUserRequest createUserRequest);
}
