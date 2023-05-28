package ru.hack.administrationservice.models.test.questions;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hack.administrationservice.models.test.DifficultyLevel;
import ru.hack.administrationservice.models.test.Option;
import ru.hack.administrationservice.models.test.QuestionType;

import java.util.List;

//@Document(collection = "question")
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
public abstract class Question {

    private QuestionType type;

    private DifficultyLevel difficultyLevel;

    private String questionText;

    private List<Option> options;

}


