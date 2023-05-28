package ru.hack.educationservice.models.questions;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hack.educationservice.models.DifficultyLevel;
import ru.hack.educationservice.models.QuestionType;
import ru.hack.educationservice.models.Option;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextQuestion.class, name = "TEXT"),
        @JsonSubTypes.Type(value = MusicImageQuestion.class, name = "MUSIC_IMAGE"),
        @JsonSubTypes.Type(value = VideoMusicQuestion.class, name = "VIDEO_MUSIC"),
        @JsonSubTypes.Type(value = PuzzleQuestion.class, name = "PUZZLE")
})
public class Question {

    private QuestionType type;

    private DifficultyLevel difficultyLevel;

    private String questionText;

    private List<Option> options;

}


