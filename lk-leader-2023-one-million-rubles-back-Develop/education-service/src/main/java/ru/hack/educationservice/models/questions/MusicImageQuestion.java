package ru.hack.educationservice.models.questions;

import lombok.*;
import ru.hack.educationservice.models.DifficultyLevel;
import ru.hack.educationservice.models.QuestionType;
import ru.hack.educationservice.models.Option;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MusicImageQuestion extends Question {
    private String musicFragmentLink;

    public MusicImageQuestion(DifficultyLevel difficultyLevel, String questionText, List<Option> options, String musicFragmentLink) {
        super(QuestionType.MUSIC_IMAGE, difficultyLevel, questionText, options);
        this.musicFragmentLink = musicFragmentLink;
    }
}


