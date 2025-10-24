package com.example.ClutchApi.business.abstracts;

import java.util.List;

import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.SelectFavTeam;

public interface  TeamsService {
    ApiResponse<List<SelectFavTeam>> getSelectFavTeams();
}
