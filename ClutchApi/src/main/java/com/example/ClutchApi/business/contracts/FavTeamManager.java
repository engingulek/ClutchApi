package com.example.ClutchApi.business.contracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClutchApi.business.abstracts.FavTeamService;
import com.example.ClutchApi.core.mappers.ModelMapperService;
import com.example.ClutchApi.core.request.FavTeamRequest;
import com.example.ClutchApi.core.response.CreatedDataResponse;
import com.example.ClutchApi.core.response.MessageType;

import com.example.ClutchApi.dataAccess.FavTeamRepository;
import com.example.ClutchApi.entities.FavTeam;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class FavTeamManager implements FavTeamService{
      @Autowired
    private ModelMapperService modelMapperService;

    @Autowired
    private FavTeamRepository favTeamRepository;

    @Override
    public CreatedDataResponse addFavTeam(FavTeamRequest favTeamRequest) {

        if (favTeamRequest.getTeams() == null || favTeamRequest.getTeams().length != 2) {
            return new CreatedDataResponse(false, MessageType.DATA_NOT_ADD_TO_DATABASE);
        }else{

            if (favTeamRepository.existsByUuid(favTeamRequest.getUuid())) {
                return new CreatedDataResponse(false, MessageType.UUI_ALREADY_EXISTS);
            }else{
                 FavTeam favTeam = new FavTeam(favTeamRequest.getUuid(), favTeamRequest.getTeams());
            
            this.favTeamRepository.save(favTeam);
            return new CreatedDataResponse(true, MessageType.DATA_ADD_TO_DATABASE_SUCCESS);
            }

        }
    }
}
