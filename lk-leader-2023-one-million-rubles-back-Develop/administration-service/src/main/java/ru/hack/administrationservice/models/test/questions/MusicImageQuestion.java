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
public class MusicImageQuestion extends Question {
    private String musicFragmentLink;

    public MusicImageQuestion(DifficultyLevel difficultyLevel, String questionText, List<Option> options, String musicFragmentLink) {
        super(QuestionType.MUSIC_IMAGE, difficultyLevel, questionText, options);
        this.musicFragmentLink = musicFragmentLink;
    }
}


