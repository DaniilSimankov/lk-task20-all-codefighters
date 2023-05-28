package ru.hack.educationservice.models.questions;

import lombok.*;
import ru.hack.educationservice.models.DifficultyLevel;
import ru.hack.educationservice.models.Option;
import ru.hack.educationservice.models.QuestionType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PuzzleQuestion extends Question {
    private String imageUrl;

    public PuzzleQuestion(DifficultyLevel difficultyLevel, String questionText, List<Option> options, String imageUrl) {
        super(QuestionType.PUZZLE, difficultyLevel, questionText, options);
        this.imageUrl = imageUrl;
    }
}

