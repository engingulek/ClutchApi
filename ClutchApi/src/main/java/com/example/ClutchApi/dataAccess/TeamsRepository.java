package com.example.ClutchApi.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ClutchApi.entities.Teams;

public interface TeamsRepository extends  JpaRepository<Teams, Integer> {
    
}
