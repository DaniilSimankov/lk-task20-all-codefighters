package ru.hack.administrationservice.models.test.questions;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hack.administrationservice.models.test.DifficultyLevel;
import ru.hack.administrationservice.models.test.Option;
import ru.hack.administrationservice.models.test.QuestionType;

import java.util.List;

@Data
@NoArgsConstructor
public class TextQuestion extends Question {

    public TextQuestion(DifficultyLevel difficultyLevel, String questionText, List<Option> options) {
        super(QuestionType.TEXT, difficultyLevel, questionText, options);
    }
}



