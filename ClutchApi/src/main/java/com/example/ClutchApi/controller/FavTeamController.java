package com.example.ClutchApi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClutchApi.business.abstracts.FavTeamService;
import com.example.ClutchApi.core.request.FavTeamRequest;
import com.example.ClutchApi.core.response.CreatedDataResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@RestController
@RequestMapping("api/favTeams")
@AllArgsConstructor
@NoArgsConstructor
public class FavTeamController {
    @Autowired
    private FavTeamService favTeamService;

    @PostMapping("/addFavTeam")
    public ResponseEntity<CreatedDataResponse> addFavTeam(@RequestBody FavTeamRequest addFavTeamRequest) {
        CreatedDataResponse response = favTeamService.addFavTeam(addFavTeamRequest);
        if (!response.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } else{
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        
    }
}
