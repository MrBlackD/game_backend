package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private String user;
    private String action;
    @Builder.Default
    private Set<User> users = new HashSet<>();
    private String answer;
    @Builder.Default
    private Integer currentQuestion = 0;
    private final List<Question> questions = List.of(
            // первый раунд
            new Question(1, false, "IzjoDZ_vb9E", "Заебись вода", 0, 26000, 2199, Round.builder().round(1).build()),
            new Question(2, false, "siJDYhunYbM", "Никогда не разучишься", 208, 28000, 5500, Round.builder().round(1).build()),
            new Question(3, false, "siJDYhunYbM", "Ни одного мячика не уронил", 742, 105000, 2800, Round.builder().round(1).build()),
            new Question(4, false, "wLCfkCkDMlw", "Снимет штаны", 322, 43000, 19400, Round.builder().round(1).build()),
            new Question(5, false, "W1NgTYCnwVM", "Домой", 56, 6300, 1500, Round.builder().round(1).build()),
            Question.builder().showResults(true).build(),
            Question.builder().round(new Round(2, "Второй раунд", "Очки (+2)", true)).build(),
            // второй раунд
            new Question(6, false, "ggzMrfuCik8", "Поздавляю конечно их, но не от всего сердца", 39, 7000, 32700, Round.builder().round(2).build()),
            new Question(7, false, "N7SklXvhxMc", "Дождик-хуеждик", 0, 52500, 6000, Round.builder().round(2).build()),
            new Question(8, false, "DhLLF6cAn-s", "Ну что вы пристали с этой дорогой", 0, 34000, 16000, Round.builder().round(2).build()),
            new Question(9, false, "BEEv9Am3ytI", "Алло Руслан подъедь пожалуйста", 47, 17000, 10000, Round.builder().round(2).build()),
            Question.builder().showResults(true).build(),
            Question.builder().round(new Round(3, "Финальный раунд", "Очки (+3)", true)).build(),
            // третий раунд
            new Question(10, false, "YSsKw8gRVlY", "Вернее смотреть могут не только лишь все", 0, 5000, 5000, Round.builder().round(3).build()),
            new Question(11, false, "TVwvcGajoQg", "Я никогда не поеду в Китай какать на огороды", 0, 41000, 4000, Round.builder().round(3).build()),
            new Question(12, false, "FJO_iCgftZk", "Тоскливый район, город Грусть, проспекты Разочарования дом 13", 0, 7000, 13000, Round.builder().round(1).build()),
            Question.builder().round(new Round(4, "Последний вопрос", "Очки (+4)", true)).build(),
            new Question(13, false, "eh0gRBbALYk", "КГБ", 0, 50000, 10000, Round.builder().round(1).build()),
            Question.builder().showResults(true).build()
    );
}
