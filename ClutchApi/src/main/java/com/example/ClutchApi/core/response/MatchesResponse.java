package com.example.ClutchApi.core.response;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MatchesResponse {
    private Integer  matchId;
    private String homeTeamName;
    private String awayTeamName;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private String homeTeamLogoUrl;
    private String awayTeamLogoUrl;
    private String stadiumName;
    private LocalTime matchTime;
    private Boolean isPlayed;
}
