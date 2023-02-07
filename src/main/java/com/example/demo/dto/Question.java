package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Integer number;
    private Boolean showResults;
    private String id;
    private String answer;
    private Integer start;
    private Integer duration;
    private Integer afterDuration;
    private Round round;
}
