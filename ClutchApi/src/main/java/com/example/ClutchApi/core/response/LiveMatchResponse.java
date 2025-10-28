package com.example.ClutchApi.core.response;

import lombok.Data;

@Data
public class LiveMatchResponse {
    private Long matchId;
    private int week;
    private String minute;
    private String homeTeamName;
    private String awayTeamName;
    private int homeTeamScore;
    private int awayTeamScore;
    private String stadiumName;
    private String match_state;
}