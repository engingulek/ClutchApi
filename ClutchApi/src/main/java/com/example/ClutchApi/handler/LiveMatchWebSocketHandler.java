package com.example.ClutchApi.handler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.ClutchApi.dataAccess.LiveMatchRepository;
import com.example.ClutchApi.entities.LiveMatch;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LiveMatchWebSocketHandler extends TextWebSocketHandler {
      private static final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private LiveMatchRepository liveMatchRepository;

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
        String json = objectMapper.writeValueAsString(liveMatches);
        session.sendMessage(new TextMessage(json));
    }

    // Tüm bağlı client'lara broadcast
    public void broadcastLiveMatches(List<LiveMatch> liveMatches) {
        try {
            String json = objectMapper.writeValueAsString(liveMatches);
            for (WebSocketSession session : sessions) {
                if (session.isOpen()) {
                    session.sendMessage(new TextMessage(json));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
