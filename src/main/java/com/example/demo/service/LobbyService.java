package com.example.demo.service;

import com.example.demo.entity.Lobby;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LobbyService {
    private static Map<String, Lobby> lobbies = new HashMap<>();

    private String generateCode() {
        return String.format("%04d", new Random().nextInt(10000));
    }

    public Lobby createLobby(String userId) {
        Lobby lobby = Lobby.builder().id(UUID.randomUUID().toString()).ownerId(userId).code(this.generateCode()).participants(new ArrayList<>()).status("waiting").build();
        lobbies.put(lobby.getId(), lobby);
        return lobby;
    }

    public Lobby join(String code, String userId) {
        Lobby lobby = lobbies.values().stream().filter(i -> i.getCode().equals(code)).findFirst().get();
        if (!lobby.getParticipants().contains(userId)) {
            lobby.getParticipants().add(userId);
        }
        return lobby;
    }

    public Lobby removeParticipant(String code, String userId) {
        Lobby lobby = this.getLobby(code);
        if (lobby.getOwnerId().equals(userId)) {
            lobbies.remove(lobby.getId());
            return null;
        }
        List<String> participants = lobby.getParticipants();
        participants.remove(userId);
        return lobby;
    }

    public Lobby getLobby(String code) {
        return lobbies.values().stream().filter(i -> i.getCode().equals(code)).findFirst().get();
    }
}
