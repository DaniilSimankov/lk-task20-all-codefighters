package ru.lk.task20.newsservice.model.content.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Option {
    private String text;
    private boolean isCorrect;
}
