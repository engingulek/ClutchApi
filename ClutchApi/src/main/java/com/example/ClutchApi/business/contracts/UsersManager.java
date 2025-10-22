package com.example.ClutchApi.business.contracts;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClutchApi.business.abstracts.UsersService;
import com.example.ClutchApi.core.mappers.ModelMapperService;
import com.example.ClutchApi.core.request.LoginRequest;
import com.example.ClutchApi.core.request.UserRequest;
import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.ErrorMessage;
import com.example.ClutchApi.dataAccess.UsersRepository;
import com.example.ClutchApi.entities.Users;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class UsersManager implements  UsersService {
    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private ModelMapperService modelMapperService;

@Override
public ApiResponse<Users> createUser(UserRequest userRequest) {
    Users users = this.modelMapperService.forRequest().map(userRequest, Users.class);

    boolean isExistsEmail = this.usersRepository.existsByEmail(users.getEmail());

    if(isExistsEmail){
        return new ApiResponse<>(false, ErrorMessage.EXIST_EMAIL, null);
    } else {
        Users createdUser = new Users(userRequest.getId(), userRequest.getNameSurname(),
                                      userRequest.getEmail(), userRequest.getPassword());
        Users savedUser = this.usersRepository.save(createdUser);
        return new ApiResponse<>(true, ErrorMessage.USER_CREATED, savedUser);
    }
}

   public ApiResponse<Users> login(LoginRequest loginRequest) {
        Optional<Users> userOptional = usersRepository.findByEmailAndPassword(
            loginRequest.getEmail(), loginRequest.getPassword()
        );

        if(userOptional.isPresent()) {
            return new ApiResponse<>(true, ErrorMessage.LOGIN_SUCCESS, userOptional.get());
        } else {
            return new ApiResponse<>(false, ErrorMessage.LOGIN_FAILED, null);
        }
    }



  
}
