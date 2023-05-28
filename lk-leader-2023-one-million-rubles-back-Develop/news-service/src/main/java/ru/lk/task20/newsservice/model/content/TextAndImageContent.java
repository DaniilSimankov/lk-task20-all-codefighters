package ru.lk.task20.newsservice.model.content;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;

import java.util.List;

@JsonTypeName("TextAndImageContent")
public class TextAndImageContent extends NewsContent {

    public TextAndImageContent(List<String> imageUrls, String text) {
        super("TextAndImageContent");
        this.add("imageUrls", imageUrls);
        this.add("text", text);
    }

    public List<String> getImageUrls() {
        return (List<String>) this.getData().get("imageUrls");
    }

    public String getText() {
        return (String) this.getData().get("text");
    }
}
