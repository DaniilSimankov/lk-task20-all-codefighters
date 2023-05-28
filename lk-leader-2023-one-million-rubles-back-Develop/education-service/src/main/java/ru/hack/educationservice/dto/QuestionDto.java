package ru.hack.educationservice.dto;

import lombok.Getter;
import lombok.Setter;
import ru.hack.educationservice.models.DifficultyLevel;
import ru.hack.educationservice.models.QuestionType;

import java.util.List;

@Getter
@Setter
public class QuestionDto {
    private QuestionType type;
    private DifficultyLevel difficultyLevel;
    private String questionText;
    private String answer;
    private String videoLink;
    private List<String> answerOptions;
    private String correctAnswer;

    // Геттеры, сеттеры и конструкторы
}
