package com.example.ClutchApi.business.contracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClutchApi.business.abstracts.UsersService;
import com.example.ClutchApi.core.mappers.ModelMapperService;
import com.example.ClutchApi.core.request.CreateUserRequest;
import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.CreateUserResponse;
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
    public ApiResponse<CreateUserResponse> createUser(CreateUserRequest createUserRequest) {
      
       Users users = this.modelMapperService.forRequest().map(createUserRequest, Users.class);

    boolean isExistsId = this.usersRepository.existsByUuid(users.getUuid());

    if(isExistsId){
        return new ApiResponse<>(false, ErrorMessage.EXIST_ID, null);
    } else {
        Users createdUser = new Users(createUserRequest.getUuid(), createUserRequest.getNameSurname(),
                                      createUserRequest.getEmail());
        Users savedUser = this.usersRepository.save(createdUser);
        CreateUserResponse createUserResponse = new CreateUserResponse(savedUser.getId());
        return new ApiResponse<>(true, ErrorMessage.USER_CREATED, createUserResponse);
    }
    }









  
}
