package com.example.ClutchApi.entities;

import java.time.LocalTime;

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
@Table(name = "matches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matchId;

    @Column(nullable = false)
    private int week;

    @ManyToOne
    @JoinColumn(name = "home_team_id", nullable = false)
    private Teams homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id", nullable = false)
    private Teams awayTeam;

    @ManyToOne
    @JoinColumn(name = "stadium_id", nullable = false)
    private Stadium stadium;

    @Column(nullable = false)
    private LocalTime matchTime;

    @Column(nullable = false)
    private boolean isPlayed;

    private Integer homeScore;
    private Integer awayScore;
}
