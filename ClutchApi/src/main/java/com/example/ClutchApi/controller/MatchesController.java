package com.example.ClutchApi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClutchApi.business.abstracts.MatchesService;
import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.MatchesResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@RestController
@RequestMapping("api/matches")
@AllArgsConstructor
@NoArgsConstructor
public class MatchesController {
    @Autowired
    private MatchesService matchesService;
    
    @GetMapping("/todayMatches")
    public ResponseEntity<ApiResponse<List<MatchesResponse>>> getTodayMatches() {
        ApiResponse<List<MatchesResponse>> matches  = matchesService.getMatches(5);
        return ResponseEntity.status(HttpStatus.OK).body(matches);
    }
}
