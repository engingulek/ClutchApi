package com.example.ClutchApi.core.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LiveMatchUpdateHomeScoreRequest {
    private Integer  matchId;
    private int homeTeamScore;
  
   
}
