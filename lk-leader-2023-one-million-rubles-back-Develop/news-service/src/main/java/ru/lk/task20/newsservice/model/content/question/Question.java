package ru.lk.task20.newsservice.model.content.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class Question {
    private String text;
    private List<Option> options;
}
