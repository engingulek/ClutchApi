package com.example.ClutchApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClutchApi.core.request.LiveMatchUpdateHomeScoreRequest;
import com.example.ClutchApi.dataAccess.LiveMatchRepository;
import com.example.ClutchApi.entities.LiveMatch;
import com.example.ClutchApi.handler.LiveMatchWebSocketHandler;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@RestController
@RequestMapping("api/liveMatches")
@AllArgsConstructor
@NoArgsConstructor
public class LiveMatchController {
     @Autowired
    private LiveMatchRepository liveMatchRepository;

    @Autowired
    private LiveMatchWebSocketHandler webSocketHandler;

    @PutMapping("/updateHomeAwayScore")
    public Boolean updateLiveMatchScore(@RequestBody LiveMatchUpdateHomeScoreRequest request) {
      
        Optional<LiveMatch> optionalMatch = liveMatchRepository.findById(request.getMatchId());

        if(optionalMatch.isPresent()){
            LiveMatch match = optionalMatch.get();

          
            
            match.setHomeTeamScore(request.getHomeTeamScore());
            
            

            liveMatchRepository.save(match);

          
            List<LiveMatch> allMatches = liveMatchRepository.findAll();
            webSocketHandler.broadcastLiveMatches(allMatches);

            return true;
        } else {
            return false;
        }
    }
}
