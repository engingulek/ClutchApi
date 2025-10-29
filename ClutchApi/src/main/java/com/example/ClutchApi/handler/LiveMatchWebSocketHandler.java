package com.example.ClutchApi.handler;



import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.ClutchApi.core.mappers.ModelMapperService;
import com.example.ClutchApi.core.response.ApiResponse;
import com.example.ClutchApi.core.response.LiveMatchResponse;
import com.example.ClutchApi.core.response.MessageType;
import com.example.ClutchApi.dataAccess.LiveMatchRepository;
import com.example.ClutchApi.entities.LiveMatch;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LiveMatchWebSocketHandler extends TextWebSocketHandler {
      private static final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private LiveMatchRepository liveMatchRepository;

     @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        sendAllLiveMatches(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) {
        sessions.remove(session);
    }

    // Bağlanan client'a tüm canlı maçları gönder
    private void sendAllLiveMatches(WebSocketSession session) throws Exception {
        List<LiveMatch> liveMatches = liveMatchRepository.findAll();
        List<LiveMatchResponse> mappedLiveMatches = liveMatches.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        String json = objectMapper.writeValueAsString(   new  ApiResponse<>(true, MessageType.SUCCESS_FETCH, mappedLiveMatches));
        
        session.sendMessage(new TextMessage(json));
    }

    // Tüm bağlı client'lara broadcast
    public void broadcastLiveMatches(List<LiveMatch> liveMatches) {
List<LiveMatchResponse> mappedLiveMatches = liveMatches.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        try {
            String json = objectMapper.writeValueAsString(

             new  ApiResponse<>(true, MessageType.SUCCESS_FETCH, mappedLiveMatches)
            );
            for (WebSocketSession session : sessions) {
                if (session.isOpen()) {
                    session.sendMessage(new TextMessage(json));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }

      private LiveMatchResponse convertToResponse(LiveMatch match) {
        return new LiveMatchResponse(
                match.getMatchId(),
                match.getWeek(),
                match.getMinute(),
                match.getHomeTeam().getName(),  // Teams entity’sinden isim alıyoruz
                match.getAwayTeam().getName(),
                match.getHomeTeamScore(),
                match.getAwayTeamScore(),
                match.getHomeTeam().getImageUrl(), // Teams entity’sinden logo URL alıyoruz
                match.getAwayTeam().getImageUrl(),
                match.getStadium().getStadiumName(),   // Stadium entity’sinden isim alıyoruz
                match.getMatch_state()
        );
    }
}
