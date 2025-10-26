package com.example.ClutchApi.business.abstracts;

import com.example.ClutchApi.core.request.FavTeamRequest;
import com.example.ClutchApi.core.response.CreatedDataResponse;

public interface  FavTeamService {
    

    CreatedDataResponse addFavTeam(FavTeamRequest favTeamRequest);
}
