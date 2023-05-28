package ru.lk.task20.videocourseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lk.task20.videocourseservice.dto.LessonResponse;
import ru.lk.task20.videocourseservice.model.Lesson;
import ru.lk.task20.videocourseservice.repository.LessonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<LessonResponse> getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        return lessons.stream()
                .map(this::mapToLessonResponse)
                .collect(Collectors.toList());
    }

    private LessonResponse mapToLessonResponse(Lesson lesson) {
        return new LessonResponse(lesson.getId(), lesson.getName(), lesson.getVideoUrl());
    }
}
