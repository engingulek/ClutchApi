package com.example.ClutchApi.dataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ClutchApi.entities.Users;

public interface  UsersRepository extends JpaRepository<Users, String> {
      boolean existsByEmail(String email);
       Optional<Users> findByEmailAndPassword(String email, String password);
}
