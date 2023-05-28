package ru.hack.educationservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Option {
    private String text;
    private boolean isAnswer;
}
