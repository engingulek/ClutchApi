package com.example.ClutchApi.business.abstracts;

import java.util.List;

import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.LiveMatchResponse;

public interface  LiveMatchService {
    ApiResponse<List<LiveMatchResponse>> getAllLiveMatches();
}
