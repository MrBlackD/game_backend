package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private String name;
    private String answer;
    @Builder.Default
    private Integer score = 0;
    @Builder.Default
    private final String avatar = "https://api.multiavatar.com/" + UUID.randomUUID() + ".svg";
}
