package com.example.ClutchApi.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ClutchApi.entities.LiveMatch;

public interface LiveMatchRepository extends JpaRepository<LiveMatch, Integer> {
    
}
