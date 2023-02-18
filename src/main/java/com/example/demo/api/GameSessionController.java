package com.example.demo.api;

import com.example.demo.entity.GameSession;
import com.example.demo.service.GameSessionService;
import com.example.demo.service.LobbyService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GameSessionController {
    @Autowired
    private GameSessionService gameSessionService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private LobbyService lobbyService;


    @MessageMapping("/test")
    public void processMessage(@Payload Boolean paylaod) {
        System.out.println("code: " + paylaod);
    }

    @GetMapping("/gameSession/{code}")
    public GameSession get(@PathVariable String code) {
        return gameSessionService.getByLobbyCode(code);
    }

    @PostMapping("/admin/gameSession/next")
    public GameSession next(HttpServletRequest request, @RequestBody Map<String, String> payload) {
        String id = request.getSession().getAttribute("id").toString();
        String code = payload.get("code");
        if(!lobbyService.getLobby(code).getOwnerId().equals(id)){
            throw new Error("NOT AN OWNER");
        }
        GameSession next = this.gameSessionService.next(code);
        this.simpMessagingTemplate.convertAndSend("/game/" + code,next);
        return next;
    }
}
