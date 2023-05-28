package ru.hack.administrationservice.models.test.questions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hack.administrationservice.models.test.DifficultyLevel;
import ru.hack.administrationservice.models.test.Option;
import ru.hack.administrationservice.models.test.QuestionType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PuzzleQuestion extends Question {
    private String imageUrl;

    public PuzzleQuestion(QuestionType type, DifficultyLevel difficultyLevel, String questionText, List<Option> options, String imageUrl) {
        super(QuestionType.PUZZLE, difficultyLevel, questionText, options);
        this.imageUrl = imageUrl;
    }
}
