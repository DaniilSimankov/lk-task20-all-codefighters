package ru.hack.educationservice.models.questions;

import lombok.*;
import ru.hack.educationservice.models.DifficultyLevel;
import ru.hack.educationservice.models.QuestionType;
import ru.hack.educationservice.models.Option;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
public class TextQuestion extends Question {

    public TextQuestion(DifficultyLevel difficultyLevel, String questionText, List<Option> options) {
        super(QuestionType.TEXT, difficultyLevel, questionText, options);
    }
}



