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
public class VideoMusicQuestion extends Question {
    private String videoLink;

    public VideoMusicQuestion(DifficultyLevel difficultyLevel, String questionText, List<Option> options, String videoLink) {
        super(QuestionType.VIDEO_MUSIC, difficultyLevel, questionText, options);
        this.videoLink = videoLink;
    }
}


