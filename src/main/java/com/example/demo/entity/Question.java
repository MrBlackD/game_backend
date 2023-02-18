package com.example.demo.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Question extends Screen {
    String text;
    List<String> answerVariants;
    String rightAnswer;
    String video;
    Integer start;
    Integer duration;
    @Builder.Default
    String questionType = "video";
}
