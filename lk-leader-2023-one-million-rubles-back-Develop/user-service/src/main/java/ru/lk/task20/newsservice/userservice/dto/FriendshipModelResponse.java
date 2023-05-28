package ru.lk.task20.newsservice.userservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FriendshipModelResponse {
    private String nameFrom;
    private String fromPhotoUrl;
}
