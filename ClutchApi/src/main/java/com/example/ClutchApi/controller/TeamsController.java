package com.example.ClutchApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClutchApi.business.abstracts.TeamsService;
import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.SelectFavTeam;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/teams")
@AllArgsConstructor
@NoArgsConstructor


public class TeamsController {
    @Autowired
    private TeamsService teamsService;

    @GetMapping("/selectFavTeams")
    public ResponseEntity<ApiResponse<List<SelectFavTeam>>> getSelectFavTeams() {
        ApiResponse<List<SelectFavTeam>> response = teamsService.getSelectFavTeams();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}