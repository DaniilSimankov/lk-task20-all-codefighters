package ru.lk.task20.newsservice.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    WAITING("WAITING"),
    ACCEPTED("ACCEPTED"),
    REJECTED("REJECTED");

    private String text;

}
