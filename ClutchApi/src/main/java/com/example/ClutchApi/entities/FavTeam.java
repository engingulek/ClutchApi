package com.example.ClutchApi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fav_team")
@Getter
@Setter
@AllArgsConstructor
public class FavTeam {


    public FavTeam(String uuid, Integer[] teams) {
        this.uuid = uuid;
        this.teams = teams;
    }

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid; // Artık otomatik değil, dışarıdan gönderilecek

    @Column(name = "teams", columnDefinition = "integer[]", nullable = false)
    private Integer[] teams;
}
