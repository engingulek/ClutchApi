package com.example.ClutchApi.business.contracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClutchApi.business.abstracts.TeamsService;
import com.example.ClutchApi.core.mappers.ModelMapperService;
import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.ErrorMessage;
import com.example.ClutchApi.core.response.SelectFavTeam;
import com.example.ClutchApi.dataAccess.TeamsRepository;
import com.example.ClutchApi.entities.Teams;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TeamsManager implements TeamsService {
    @Autowired
    private ModelMapperService modelMapperService;


    @Autowired
    private TeamsRepository teamsRepository;
    @Override
    public ApiResponse<List<SelectFavTeam>> getSelectFavTeams() {
        List<Teams> favTeams = this.teamsRepository.findAll();

        List<SelectFavTeam> response = favTeams.stream()
            .map(team -> this.modelMapperService.forResponse().map(team, SelectFavTeam.class))
            .toList();
        return new ApiResponse<>(true, ErrorMessage.SUCCESS_FETCH, response);
    }
    
}
