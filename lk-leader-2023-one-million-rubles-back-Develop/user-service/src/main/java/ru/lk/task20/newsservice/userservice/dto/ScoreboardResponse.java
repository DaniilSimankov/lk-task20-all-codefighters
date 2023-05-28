package ru.lk.task20.newsservice.userservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScoreboardResponse {
    private String name;
    private int xp;
    private String photoUrl;
}
