package com.example.ClutchApi.business.abstracts;

import java.util.List;

import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.MatchesResponse;

public interface  MatchesService {
    ApiResponse<List<MatchesResponse>> getMatches(Integer week);
}
