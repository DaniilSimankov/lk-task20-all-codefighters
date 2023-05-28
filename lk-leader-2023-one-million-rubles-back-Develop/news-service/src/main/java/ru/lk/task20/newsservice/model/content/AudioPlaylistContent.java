package ru.lk.task20.newsservice.model.content;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;

import java.util.List;

@JsonTypeName("AudioPlaylistContent")
public class AudioPlaylistContent extends NewsContent {

    public AudioPlaylistContent(List<String> audioPlaylistUrls) {
        super("AudioPlaylistContent");
        this.add("audioPlaylistUrls", audioPlaylistUrls);
    }

    public List<String> getAudioPlaylistUrls() {
        return (List<String>) this.getData().get("audioPlaylistUrls");
    }
}
