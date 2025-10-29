package com.example.ClutchApi.business.contracts;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClutchApi.business.abstracts.MatchesService;
import com.example.ClutchApi.core.mappers.ModelMapperService;
import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.MatchesResponse;
import com.example.ClutchApi.core.response.MessageType;
import com.example.ClutchApi.dataAccess.MatchesRepository;
import com.example.ClutchApi.entities.Matches;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MatchesManager implements MatchesService {
     @Autowired
    private MatchesRepository matchesRepository;
        @Autowired
    private ModelMapperService modelMapperService;
        @Override
        public ApiResponse<List<MatchesResponse>> getMatches(Integer week) {
            List<MatchesResponse> matches = matchesRepository.findByWeek(week).stream()
            .map(this::convertToMatchResponse)
            .collect(Collectors.toList());
            return new ApiResponse<>(true, MessageType.SUCCESS_FETCH, matches);
            
        }

        private MatchesResponse convertToMatchResponse(Matches match) {
            return new MatchesResponse(
                match.getMatchId(),
                match.getHomeTeam().getName(),
                match.getAwayTeam().getName(),
                match.getHomeScore(),
                match.getAwayScore(),
                match.getHomeTeam().getImageUrl(),
                match.getAwayTeam().getImageUrl(),
                match.getStadium().getStadiumName(),
                match.getMatchTime(),
                match.isPlayed()
               
            );
           }
}
