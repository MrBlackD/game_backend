package com.example.demo.api;

import com.example.demo.entity.Answer;
import com.example.demo.entity.GameSession;
import com.example.demo.service.GameSessionService;
import com.example.demo.service.LobbyService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class AnswersController {
    @Autowired
    private GameSessionService gameSessionService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private LobbyService lobbyService;

    @PostMapping("/answer")
    public String sendAnswer(HttpServletRequest request, @RequestBody Map<String, String> body) {
        String id = request.getSession().getAttribute("id").toString();
        String code = body.get("code");
        String answer = body.get("answer");
        String index = body.get("index");
        GameSession gameSession = this.gameSessionService.getByLobbyCode(code);
        if (!gameSession.getCurrentScreenIndex().equals(Integer.parseInt(index))) {
            throw new Error("Неуспешный ответ");
        }
        Optional<Answer> first = gameSession.getAnswers().stream().filter(i -> i.getUserId().equals(id)).findFirst();
        first.ifPresent(value -> value.setAnswer(answer));
        if (first.isEmpty()) {
            gameSession.getAnswers().add(new Answer(id, answer));
        }
        this.simpMessagingTemplate.convertAndSend("/game/"+code, gameSession);
        return answer;
    }
}
