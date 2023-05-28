package ru.lk.task20.newsservice.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.lk.task20.newsservice.model.Story;
import ru.lk.task20.newsservice.repository.StoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StoryService {

    private final StoryRepository storyRepository;

    public List<Story> getAllStories() {
        return null;
    }

    public Story getStoryById(@NonNull String id) {
        return null;
    }
}
