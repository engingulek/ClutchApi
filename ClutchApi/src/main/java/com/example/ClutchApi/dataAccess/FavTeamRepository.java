package com.example.ClutchApi.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ClutchApi.entities.FavTeam;

public interface  FavTeamRepository  extends JpaRepository<FavTeam, Integer> {
    boolean existsByUuid(String uuid);
}
