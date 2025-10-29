package com.example.ClutchApi.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ClutchApi.entities.Matches;

public interface  MatchesRepository  extends JpaRepository<Matches, Integer> {
    List<Matches> findByWeek(Integer week);
}
