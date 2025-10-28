package com.example.ClutchApi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "live_matches")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LiveMatch {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    @Column(nullable = false)
    private int week;

    @Column(length = 10)
    private String minute;  // "45+2" gibi değerler için string

    @ManyToOne
    @JoinColumn(name = "home_team_id", nullable = false)
    private Teams homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id", nullable = false)
    private Teams awayTeam;

    @Column(name = "home_team_score", nullable = false)
    private int homeTeamScore;

    @Column(name = "away_team_score", nullable = false)
    private int awayTeamScore;

    @ManyToOne
    @JoinColumn(name = "stadium_id", nullable = false)
    private Stadium stadium;

    @Column(length = 20, nullable = false)
    private String match_state;  
}
