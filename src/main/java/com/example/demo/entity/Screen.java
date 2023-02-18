package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder

@AllArgsConstructor
@NoArgsConstructor
public class Screen {
    String type;
    Integer timer;
    Integer state;
}
