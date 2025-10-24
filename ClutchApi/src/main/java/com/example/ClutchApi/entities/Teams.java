package com.example.ClutchApi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teams")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teams {

    public Teams(String name, String shortName, String imageUrl) {
        this.name = name;
        this.shortName = shortName;
        this.imageUrl = imageUrl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "image_url")
    private String imageUrl;
}
