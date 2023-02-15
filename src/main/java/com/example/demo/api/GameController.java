package com.example.demo.api;

import com.example.demo.dto.Game;
import com.example.demo.dto.Question;
import com.example.demo.dto.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class GameController {
    private Game globalGame = new Game();
    private final List<String> avatars = List.of(
            "https://api.multiavatar.com/db12c4df5fca74bd9c.svg",
            "https://api.multiavatar.com/Starcrasher.svg",
            "https://api.multiavatar.com/c26eddc51ac91b58a4.svg",
            "https://api.multiavatar.com/9973e06fb8991e0597.svg",
            "https://api.multiavatar.com/906c21b6557ea29ff6.svg",
            "https://api.multiavatar.com/6b9638ec691d823858.svg",
            "https://api.multiavatar.com/43bd1919bd1be2a8b4.svg",
            "https://api.multiavatar.com/b5bb2a8e98ad55e8cb.svg",
            "https://api.multiavatar.com/c26c908a6ca02d9051.svg",
            "https://api.multiavatar.com/6c51858a6de67e85e6.svg",
            "https://api.multiavatar.com/2a0473886666b67d92.svg",
            "https://api.multiavatar.com/9b00a2c795698e49ac.svg",
            "https://api.multiavatar.com/5858d8ea1bcc1b9553.svg",
            "https://api.multiavatar.com/1c3896e72996d976be.svg",
            "https://api.multiavatar.com/7a211bab580165a19d.svg"
    );

    private String currentAction;

    @MessageMapping("/start")
    @SendTo("/game")
    public Game processMessage(Game game) {
        System.out.println(game.getAction());
        if (!game.getAction().equals("START_MENU")) {
            globalGame.setAction(game.getAction());
        }
        switch (game.getAction()) {
            case "USER" -> globalGame.getUsers().add(User.builder()
                    .avatar(avatars.get(globalGame.getUsers().size()))
                    .name(game.getUser())
                    .build());
            case "NEW_GAME" -> globalGame = Game.builder().action("NEW_GAME").build();
            case "ANSWER" -> {
                for (User user : globalGame.getUsers()) {
                    if (user.getName().equals(game.getUser())) {
                        user.setAnswer(game.getAnswer());
                        Question question = game.getQuestions().get(globalGame.getCurrentQuestion());
                        if (question.getAnswer().equals(game.getAnswer())) {
                            user.setScore(user.getScore() + question.getRound().getRound());
                        }
                    }
                }
            }
            case "CONTINUE" -> {
                globalGame.getUsers().forEach(user -> user.setAnswer(null));
                globalGame.setCurrentQuestion(globalGame.getCurrentQuestion() + 1);
            }
            case "SHOW_ANSWERS", "SHOW_RESULTS" -> currentAction = game.getAction();
            case "START_MENU" -> globalGame.setAction(currentAction);
        }
        return globalGame;
    }
}
