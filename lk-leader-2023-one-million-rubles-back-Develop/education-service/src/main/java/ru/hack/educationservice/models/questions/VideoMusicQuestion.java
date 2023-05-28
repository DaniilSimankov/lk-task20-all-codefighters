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
public class VideoMusicQuestion extends Question {
    private String videoLink;

    public VideoMusicQuestion(DifficultyLevel difficultyLevel, String questionText, List<Option> options, String videoLink) {
        super(QuestionType.VIDEO_MUSIC, difficultyLevel, questionText, options);
        this.videoLink = videoLink;
    }
}


