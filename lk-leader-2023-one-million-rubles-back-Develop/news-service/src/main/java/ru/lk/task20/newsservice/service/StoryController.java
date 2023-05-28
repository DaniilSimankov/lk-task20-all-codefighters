package ru.lk.task20.newsservice.service;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.lk.task20.newsservice.model.Story;

import java.util.List;

@RestController
@RequestMapping("/api/news/stories")
@AllArgsConstructor
public class StoryController {

    private final StoryService storyService;

    @GetMapping
    public List<Story> getAllStories() {
        return storyService.getAllStories();
    }

    @GetMapping("/one")
    public Story getStoryById(@RequestParam(name = "id") String id) {
        return storyService.getStoryById(id);
    }
}
