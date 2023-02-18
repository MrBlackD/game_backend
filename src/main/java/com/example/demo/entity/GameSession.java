package com.example.demo.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameSession {
    @Builder.Default
    String id = UUID.randomUUID().toString();
    String gameId;
    Integer currentScreenIndex;
    Screen currentScreen;
    Long timerStart;
    @Builder.Default
    List<Answer> answers = new ArrayList<>();
    @Builder.Default
    Map<String, Integer> players = new HashMap<>();
}
