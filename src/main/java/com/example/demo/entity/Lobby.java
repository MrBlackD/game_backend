package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lobby {
    private String id;
    private String code;
    private List<String> participants;
    private String ownerId;
    private String gameSessionId;
    private String status;
}
