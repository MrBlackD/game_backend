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
            new Question(1, false, "XaYjBtVVXJc", "Вкусный чай", 49, 21800, 6000, Round.builder().round(1).build()),
            new Question(2, false, "XaYjBtVVXJc", "Чего блять", 102, 8000, 11000, Round.builder().round(1).build()),
            new Question(3, false, "XaYjBtVVXJc", "Молодой", 164, 20000, 2000, Round.builder().round(1).build()),
            new Question(4, false, "XaYjBtVVXJc", "Умеете, могёте просто", 215, 20000, 3000, Round.builder().round(1).build()),
            new Question(5, false, "XaYjBtVVXJc", "Блять", 239, 4500, 2000, Round.builder().round(1).build()),
            Question.builder().showResults(true).build(),
            Question.builder().round(new Round(2, "Второй раунд", "Очки (x2)", true)).build(),
            // второй раунд
            new Question(6, false, "XaYjBtVVXJc", "Yes today very well", 280, 68000, 12000, Round.builder().round(2).build()),
            new Question(7, false, "826j_5ToVis", "В куринном бульоне", 33, 22000, 4000, Round.builder().round(2).build()),
            new Question(8, false, "826j_5ToVis", "Пацан к успеху шел", 273, 15000, 4000, Round.builder().round(2).build()),
            new Question(9, false, "CTpNyN8MifE", "Простите а у вас не будет одного рубля на дорогу", 60, 12000, 15000, Round.builder().round(2).build()),
            Question.builder().showResults(true).build(),
            Question.builder().round(new Round(3, "Финальный раунд", "Очки (x3)", true)).build(),
            // третий раунд
            new Question(10, false, "CTpNyN8MifE", "Алах акбар", 189, 17800, 16000, Round.builder().round(3).build()),
            new Question(11, false, "CTpNyN8MifE", "Ду хаст", 603, 9000, 5000, Round.builder().round(3).build()),
            new Question(12, false, "je7vdzPEMjM", "Это сучка бритни", 2, 14000, 20000, Round.builder().round(1).build())

    );
}
