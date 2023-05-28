package ru.lk.task20.newsservice.model.content;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;

import java.util.List;

@JsonTypeName("QAContent")
public class QAContent extends NewsContent {

    public QAContent(String imageUrl, String imageText, List<QAPair> qaPairs) {
        super("QAContent");
        this.add("imageUrl", imageUrl);
        this.add("imageText", imageText);
        this.add("qaPairs", qaPairs);
    }

    public String getImageUrl() {
        return (String) this.getData().get("imageUrl");
    }

    public String getImageText() {
        return (String) this.getData().get("imageText");
    }

    public List<QAPair> getQaPair() {
        return (List<QAPair>) this.getData().get("qaPairs");
    }
}
