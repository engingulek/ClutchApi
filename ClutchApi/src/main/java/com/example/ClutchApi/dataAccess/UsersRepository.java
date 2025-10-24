package com.example.ClutchApi.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ClutchApi.entities.Users;

public interface  UsersRepository extends JpaRepository<Users, String> {
       boolean existsByUuid(String id);
      
}
