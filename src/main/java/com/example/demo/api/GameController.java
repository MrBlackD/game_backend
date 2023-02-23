package com.example.demo.api;

import com.example.demo.dto.Action;
import com.example.demo.dto.Game;
import com.example.demo.dto.GameStream;
import com.example.demo.dto.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import java.util.Set;

@Controller
@RequiredArgsConstructor
public class GameController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    private Game stateGame = new Game();

    /**
     * Получить текущее состояние игры
     * Обновление страницы для игрока
     * Не аффектит остальных игроков
     * <p>
     * Если пользователя нет в текущей игре, значит нужно дать информацию об этом на фронт
     *
     * @return текущее состояниее игры
     */
    @MessageMapping("/start")
    @SendToUser("/topic/game")
    public Game userMessage(Game game) {
        if (game.getPlayer() == null || playerIsNotPresentInCurrentGame(game)) {
            stateGame.setPlayer(null);
        } else {
            stateGame.setPlayer(game.getPlayer());
        }
        return stateGame;
    }

    private boolean playerIsNotPresentInCurrentGame(Game game) {
        Set<Player> players = stateGame.getPlayers();
        return CollectionUtils.isEmpty(players) || players.stream().noneMatch(player -> player.getName().equals(game.getPlayer().getName()));
    }

    /**
     * Получить текущее состояние игры
     * Обновление страницы для игрока
     * Не аффектит остальных игроков
     * <p>
     * Если пользователя нет в текущей игре, значит нужно дать информацию об этом на фронт
     *
     * @return текущее состояниее игры
     */
    @MessageMapping("/new_player")
    @SendToUser("/topic/game")
    public Game newPlayer(Game game) {
        if (stateGame.getPlayers().stream().anyMatch(p -> p.getName().equals(game.getPlayer().getName()))) {
            game.setAction("ADD_PLAYER_ERROR");
        } else {
            stateGame.getPlayers().add(game.getPlayer());
            game.setAction("ADD_PLAYER_SUCCESS");
            stateGame.setAction("NEW_PLAYER");
            simpMessagingTemplate.convertAndSend("/topic/game", stateGame);
        }
        return game;
    }

    /**
     * Активное действие
     * Влияет на состояние игры
     *
     * @param game - игра
     * @return измененное состояние игры
     */
    @MessageMapping("/action")
    @SendTo("/topic/game")
    public Game gameMassage(Game game) {
        stateGame.setAction(game.getAction());
        switch (game.getAction()) {
            case "CONTINUE" -> nextStreamGame();
            case "NEW_GAME" -> stateGame = Game.builder().action("NEW_GAME").build();
            case "ANSWER" -> answer(game);
        }
        return stateGame;
    }

    private void nextStreamGame() {
        stateGame.setIndex(stateGame.getIndex() + 1);
        updateAnswers();
    }

    /**
     * Если новый вопрос то обнуляем ответы
     */
    private void updateAnswers() {
        if (stateGame.getGameStream().get(stateGame.getIndex()).getAction() == Action.QUESTION) {
            stateGame.getPlayers().forEach(player -> player.setAnswer(null));
        }
    }

    private void answer(Game game) {
        stateGame.getPlayers().stream().filter(player -> player.getName().equals(game.getPlayer().getName()))
                .forEach(player -> {
                    player.setAnswer(game.getPlayer().getAnswer());
                    player.setScore(player.getScore() + score(game.getPlayer().getAnswer()));
                });
    }

    private Integer score(String answer) {
        GameStream game = stateGame.getGameStream().get(stateGame.getIndex());
        return game.getQuestion().getAnswer().equals(answer) ? game.getRound().getNumber() : 0;
    }
}
