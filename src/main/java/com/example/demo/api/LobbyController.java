package com.example.demo.api;

import com.example.demo.entity.GameSession;
import com.example.demo.entity.Lobby;
import com.example.demo.service.GameSessionService;
import com.example.demo.service.LobbyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LobbyController {
    @Autowired
    private LobbyService lobbyService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private GameSessionService gameSessionService;
//    @Autowired
//    private JobScheduler jobScheduler;

    @GetMapping("/lobby/{code}")
    public Lobby get(HttpServletRequest request, @PathVariable String code) {
        return lobbyService.getLobby(code);
    }

    @PostMapping("/lobby")
    public Lobby create(HttpServletRequest request) {
        String id = request.getSession().getAttribute("id").toString();
        return lobbyService.createLobby(id);
    }

    @PutMapping("/lobby/{code}")
    public Lobby update(HttpServletRequest request, HttpServletResponse response, @PathVariable String code, @RequestBody Map<String, String> body) {
        String gameId = body.get("gameId");
        String id = request.getSession().getAttribute("id").toString();
        Lobby lobby = lobbyService.getLobby(code);
        if (!lobby.getOwnerId().equals(id)) {
            response.setStatus(403);
            throw new Error("Insufficient permissions");
        }
//        lobby.setGameId(gameId);
        this.simpMessagingTemplate.convertAndSend("/lobby/" + code, lobby);
        return lobby;
    }

    @PostMapping("/lobby/start")
    public Lobby start(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> body) {
        String code = body.get("code");
        String gameId = body.get("gameId");
        String id = request.getSession().getAttribute("id").toString();
        Lobby lobby = lobbyService.getLobby(code);
        if (!lobby.getOwnerId().equals(id)) {
            response.setStatus(403);
            throw new Error("Insufficient permissions");
        }
        GameSession gameSession = gameSessionService.create(gameId, lobby.getParticipants());
        lobby.setGameSessionId(gameSession.getId());
        lobby.setStatus("inProgress");
        new Thread(() -> {
            System.out.println("THREAD  started");
            gameSessionService.start(gameSession.getId(), lobby.getCode());
        }).start();
        this.simpMessagingTemplate.convertAndSend("/lobby/" + code, lobby);
        return lobby;
    }

    @PostMapping("/lobby/join")
    public Lobby join(HttpServletRequest request, @RequestBody Map<String, String> body) {
        String code = body.get("code");
        String id = request.getSession().getAttribute("id").toString();
        Lobby lobby = lobbyService.join(code, id);
        this.simpMessagingTemplate.convertAndSend("/lobby/" + code, lobby);
        return lobby;
    }

    @PostMapping("/lobby/{code}/leave")
    public Lobby leave(HttpServletRequest request, @PathVariable String code) {
        String id = request.getSession().getAttribute("id").toString();
        Lobby lobby = lobbyService.removeParticipant(code, id);
        Lobby updateLobby = lobbyService.getLobby(code);
        this.simpMessagingTemplate.convertAndSend("/lobby/" + code, updateLobby);
        return lobby;
    }

    @PostMapping("/lobby/{code}/kick")
    public Lobby leave(HttpServletRequest request, @PathVariable String code, @RequestBody Map<String, String> body) {
        String kickedUserId = body.get("userId");
        String id = request.getSession().getAttribute("id").toString();
        Lobby lobby = lobbyService.getLobby(code);
        if (!lobby.getOwnerId().equals(id)) {
            throw new Error("Not enough rights");
        }
        lobbyService.removeParticipant(code, kickedUserId);
        Lobby updateLobby = lobbyService.getLobby(code);
        this.simpMessagingTemplate.convertAndSend("/lobby/" + code, updateLobby);
        return lobby;
    }

    @GetMapping("test")
    public String test() {
        this.simpMessagingTemplate.convertAndSend("/test", true);
        this.simpMessagingTemplate.convertAndSend("/app/test", true);

        return "LOBBY";
    }

}
