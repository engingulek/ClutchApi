package com.example.ClutchApi.business.contracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClutchApi.business.abstracts.LiveMatchService;
import com.example.ClutchApi.core.mappers.ModelMapperService;
import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.LiveMatchResponse;
import com.example.ClutchApi.core.response.MessageType;
import com.example.ClutchApi.dataAccess.LiveMatchRepository;
import com.example.ClutchApi.entities.LiveMatch;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class LiveMatchManager implements LiveMatchService {

    @Autowired
    private LiveMatchRepository liveMatchRepository;

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public ApiResponse<List<LiveMatchResponse>> getAllLiveMatches() {
        List<LiveMatch> liveMatches = liveMatchRepository.findAll();

        List<LiveMatchResponse> response = liveMatches.stream()
                .map(match -> modelMapperService.forResponse().map(match, LiveMatchResponse.class))
                .toList();

        return new ApiResponse<>(true, MessageType.SUCCESS_FETCH, response);
    }
}
