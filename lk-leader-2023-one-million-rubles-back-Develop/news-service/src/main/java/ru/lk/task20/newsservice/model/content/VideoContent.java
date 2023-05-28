package ru.lk.task20.newsservice.model.content;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("VideoContent")
public class VideoContent extends NewsContent {
    private String videoUrl;

    public VideoContent(String videoUrl) {
        super("VideoContent");
        this.add("videoUrl", videoUrl);
    }

    public String getVideoUrl() {
        return (String) this.getData().get("videoUrl");
    }
}
