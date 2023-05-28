package ru.lk.task20.newsservice.model.content;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@JsonSubTypes({
        @JsonSubTypes.Type(value = TextAndImageContent.class, name = "TextAndImageContent"),
        @JsonSubTypes.Type(value = VideoContent.class, name = "VideoContent"),
        @JsonSubTypes.Type(value = QuestionContent.class, name = "QuestionContent"),
        @JsonSubTypes.Type(value = QAContent.class, name = "QAContent"),
        @JsonSubTypes.Type(value = AudioPlaylistContent.class, name = "AudioPlaylistContent"),
})
@Getter
public class NewsContent {
    private String type;

    private Map<String, Object> data = new HashMap<>();

    public NewsContent(String type) {
        this.type = type;
    }

    @JsonAnySetter
    public void add(String key, Object value) {
        data.put(key, value);
    }
}
