package com.example.ClutchApi.core.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectFavTeam {
    private Integer teamId;
    private String teamUrl;
}
