package com.example.demo.service;

import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GameSessionService {
    private List<GameSession> gameSessions = new ArrayList<>();

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private GameService gameService;
    @Autowired
    private LobbyService lobbyService;

    public GameSession create(String gameId, List<String> players) {
        GameSession gameSession = GameSession.builder().gameId(gameId).build();
        players.forEach(i -> gameSession.getPlayers().put(i, 0));
        gameSessions.add(gameSession);
        return gameSession;
    }

    public GameSession getByLobbyCode(String code) {
        Lobby lobby = lobbyService.getLobby(code);
        return gameSessions.stream().filter(i -> i.getId().equals(lobby.getGameSessionId())).findFirst().get();
    }

    public void start(String gameSessionId, String code) {
        GameSession gameSession = gameSessions.stream().filter(i -> i.getId().equals(gameSessionId)).findFirst().get();
        String gameId = gameSession.getGameId();
        Game game = this.gameService.getGame(gameId);
        gameSession.setCurrentScreenIndex(0);
        gameSession.setCurrentScreen(game.getScreens().get(0));
        gameSession.setTimerStart(new Date().getTime());
        this.simpMessagingTemplate.convertAndSend("/game/" + code, gameSession);
//        while (gameSession.getCurrentScreenIndex() < game.getScreens().size()) {
//            Screen currentScreen = gameSession.getCurrentScreen();
//            Date start = new Date();
//            while (gameSession.getTimerStart() + currentScreen.getTimer() > new Date().getTime()) ;
//            int newIndex = gameSession.getCurrentScreenIndex() + 1;
//            if(newIndex >= game.getScreens().size() ) {
//                break;
//            }
//            gameSession.setCurrentScreenIndex(newIndex);
//            gameSession.setCurrentScreen(game.getScreens().get(newIndex));
//            gameSession.setTimerStart(new Date().getTime());
//            this.simpMessagingTemplate.convertAndSend("/game/" + code, gameSession);
//        }
    }

    public GameSession next(String code) {
        GameSession gameSession = this.getByLobbyCode(code);
        String gameId = gameSession.getGameId();
        Game game = this.gameService.getGame(gameId);
        if (gameSession.getCurrentScreen().getType().equals("question")) {
            Question question = (Question) gameSession.getCurrentScreen();
            gameSession.getAnswers().forEach(answer -> {
                if (answer.getAnswer().equals(question.getRightAnswer())) {
                    gameSession.getPlayers().put(answer.getUserId(), gameSession.getPlayers().get(answer.getUserId()) + 1);
                }
            });
        }
        gameSession.getAnswers().clear();
        int newIndex = gameSession.getCurrentScreenIndex() + 1;
        if (newIndex >= game.getScreens().size()) {
            Lobby lobby = lobbyService.getLobby(code);
            lobby.setStatus("finished");
            this.simpMessagingTemplate.convertAndSend("/lobby/" + code, lobby);
            return gameSession;
        }
        gameSession.setCurrentScreenIndex(newIndex);
        gameSession.setCurrentScreen(game.getScreens().get(newIndex));
        gameSession.setCurrentScreen(game.getScreens().get(newIndex));
        gameSession.setTimerStart(new Date().getTime());
        return gameSession;
    }

    private GameSession getGameSessionById(String gameSessionId) {
        return gameSessions.stream().filter(i -> i.getId().equals(gameSessionId)).findFirst().get();
    }
}
