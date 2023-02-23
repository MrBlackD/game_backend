package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.demo.dto.Action.ANSWER;
import static com.example.demo.dto.Action.NEW_ROUND;
import static com.example.demo.dto.Action.QUESTION;
import static com.example.demo.dto.Action.SHOW_RESULTS;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private Player player;
    private String action;
    @Builder.Default
    private Set<Player> players = new HashSet<>();
    @Builder.Default
    private Integer index = -1;
    private final List<GameStream> gameStream = List.of(
            GameStream.builder().action(QUESTION).question(Question.builder().videoId("yYHSzQSTjbI").start(355).end(393).answer("Че тебе надо шнур?").answers(List.of("Ты кто такой?", "Че тебе надо шнур?", "Че тебе надо дрыщ?")).build()).round(Round.builder().number(1).build()).build(),
            GameStream.builder().action(ANSWER).question(Question.builder().videoId("yYHSzQSTjbI").start(393).end(438).answer("Че тебе надо шнур?").answers(List.of("Ты кто такой?", "Че тебе надо шнур?", "Че тебе надо дрыщ?")).build()).round(Round.builder().number(1).build()).build(),

            GameStream.builder().action(QUESTION).question(Question.builder().videoId("0JEiqacI5k8").start(95).end(109).answer("Просто опыт говно").answers(List.of("Просто опыт говно", "Просто свечки говно", "Просто передача говно")).build()).round(Round.builder().number(1).build()).build(),
            GameStream.builder().action(ANSWER).question(Question.builder().videoId("0JEiqacI5k8").start(109).end(125).answer("Просто опыт говно").answers(List.of("Просто опыт говно", "Просто свечки говно", "Просто передача говно")).build()).round(Round.builder().number(1).build()).build(),

            GameStream.builder().action(QUESTION).question(Question.builder().videoId("jtHDIIveW4U").start(0).end(28).answer("Снегом в лицо").answers(List.of("Ударит по лицу", "Снегом в лицо", "Повалит на землю")).build()).round(Round.builder().number(1).build()).build(),
            GameStream.builder().action(ANSWER).question(Question.builder().videoId("jtHDIIveW4U").start(28).end(38).answer("Снегом в лицо").answers(List.of("Ударит по лицу", "Снегом в лицо", "Повалит на землю")).build()).round(Round.builder().number(1).build()).build(),

            GameStream.builder().action(QUESTION).question(Question.builder().videoId("YHeXyVvr90g").start(570).end(580).answer("Это Akon хорош").answers(List.of("Это Akon хорош", "Не смеши людей, а ну да ты ж не умеешь", "Это я хорош")).build()).round(Round.builder().number(1).build()).build(),
            GameStream.builder().action(ANSWER).question(Question.builder().videoId("YHeXyVvr90g").start(580).end(645).answer("Это Akon хорош").answers(List.of("Это Akon хорош", "Не смеши людей, а ну да ты ж не умеешь", "Это я хорош")).build()).round(Round.builder().number(1).build()).build(),

            GameStream.builder().action(QUESTION).question(Question.builder().videoId("vAghb2zny0I").start(52).end(58).answer("Хороший кешбек").answers(List.of("Заплати Ведьмаку, чеканной монетой", "Хороший кешбек", "Казино Вулкан")).build()).round(Round.builder().number(1).build()).build(),
            GameStream.builder().action(ANSWER).question(Question.builder().videoId("vAghb2zny0I").start(58).end(67).answer("Хороший кешбек").answers(List.of("Заплати Ведьмаку, чеканной монетой", "Хороший кешбек", "Казино Вулкан")).build()).round(Round.builder().number(1).build()).build(),

            GameStream.builder().action(SHOW_RESULTS).build(),
            GameStream.builder().action(NEW_ROUND).round(Round.builder().number(2).header("Второй раунд").body("Очки (x2)").build()).build(),

            GameStream.builder().action(QUESTION).question(Question.builder().videoId("JrE0u0otCVU").start(0).end(58).answer("Слышь будь другом, запиши мне свое имя на салфетке").answers(List.of("Можешь записать свой номер на листке", "Слышь будь другом, запиши мне свое имя на салфетке", "Та официантка готова тебе дать свой номер, запиши его")).build()).round(Round.builder().number(2).build()).build(),
            GameStream.builder().action(ANSWER).question(Question.builder().videoId("JrE0u0otCVU").start(58).end(70).answer("Слышь будь другом, запиши мне свое имя на салфетке").answers(List.of("Можешь записать свой номер на листке", "Слышь будь другом, запиши мне свое имя на салфетке", "Та официантка готова тебе дать свой номер, запиши его")).build()).round(Round.builder().number(2).build()).build(),

            GameStream.builder().action(QUESTION).question(Question.builder().videoId("4gbDvU0tBu0").start(0).end(2).answer("12:05").answers(List.of("16:25", "12:20", "12:05")).build()).round(Round.builder().number(2).build()).build(),
            GameStream.builder().action(ANSWER).question(Question.builder().videoId("4gbDvU0tBu0").start(2).end(6).answer("12:05").answers(List.of("16:25", "12:20", "12:05")).build()).round(Round.builder().number(2).build()).build(),

            GameStream.builder().action(QUESTION).question(Question.builder().videoId("ik8-pImTnII").start(11).end(19).answer("Здарова отец").answers(List.of("Убейте его", "Здарова отец", "Вот мы и встретились")).build()).round(Round.builder().number(2).build()).build(),
            GameStream.builder().action(ANSWER).question(Question.builder().videoId("ik8-pImTnII").start(19).end(21).answer("Здарова отец").answers(List.of("Убейте его", "Здарова отец", "Вот мы и встретились")).build()).round(Round.builder().number(2).build()).build(),

            GameStream.builder().action(QUESTION).question(Question.builder().videoId("9Uv_3xlRI9c").start(0).end(25).answer("Он аналитик из ФБР").answers(List.of("Он самый настоящий преступник", "Он аналитик из ФБР", "Он из ЦРУ")).build()).round(Round.builder().number(2).build()).build(),
            GameStream.builder().action(ANSWER).question(Question.builder().videoId("9Uv_3xlRI9c").start(25).end(106).answer("Он аналитик из ФБР").answers(List.of("Он самый настоящий преступник", "Он аналитик из ФБР", "Он из ЦРУ")).build()).round(Round.builder().number(2).build()).build(),

            GameStream.builder().action(SHOW_RESULTS).build(),
            GameStream.builder().action(NEW_ROUND).round(Round.builder().number(3).header("Финальный раунд").body("Очки (x3)").build()).build(),

            GameStream.builder().action(QUESTION).question(Question.builder().videoId("PUdWkevNwwA").start(0).end(72).answer("Чтобы защитить душки очков от попадания краски").answers(List.of("Чтобы пряди оставлять не закрашенными", "Чтобы защитить серьги", "Чтобы защитить душки очков от попадания краски")).build()).round(Round.builder().number(3).build()).build(),
            GameStream.builder().action(ANSWER).question(Question.builder().videoId("PUdWkevNwwA").start(168).end(180).answer("Чтобы защитить душки очков от попадания краски").answers(List.of("Чтобы пряди оставлять не закрашенными", "Чтобы защитить серьги", "Чтобы защитить душки очков от попадания краски")).build()).round(Round.builder().number(3).build()).build(),

            GameStream.builder().action(QUESTION).question(Question.builder().videoId("sfpiju5ZRhE").start(40).end(62).answer("Копать червяков").answers(List.of("Чтобы пряди оставлять не закрашенными", "Чтобы защитить серьги", "Чтобы защитить душки очков от попадания краски")).build()).round(Round.builder().number(3).build()).build(),
            GameStream.builder().action(ANSWER).question(Question.builder().videoId("sfpiju5ZRhE").start(210).end(228).answer("Копать червяков").answers(List.of("Чтобы пряди оставлять не закрашенными", "Чтобы защитить серьги", "Чтобы защитить душки очков от попадания краски")).build()).round(Round.builder().number(3).build()).build(),

            GameStream.builder().action(SHOW_RESULTS).build(),
            GameStream.builder().action(NEW_ROUND).round(Round.builder().number(3).header("Финальный вопрос").body("Очки (x4)").build()).build(),

            GameStream.builder().action(QUESTION).question(Question.builder().videoId("hkntyvM5TQc").start(374).end(399).answer("Снегурочка нужна?").answers(List.of("Говно брать будете?", "Снегурочка нужна?", "Я тоже знаю Японский")).build()).round(Round.builder().number(4).build()).build(),
            GameStream.builder().action(ANSWER).question(Question.builder().videoId("hkntyvM5TQc").start(399).end(428).answer("Снегурочка нужна?").answers(List.of("Говно брать будете?", "Снегурочка нужна?", "Я тоже знаю Японский")).build()).round(Round.builder().number(4).build()).build(),

            GameStream.builder().action(SHOW_RESULTS).build()

            );
}
