package ru.lk.task20.videocourseservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.lk.task20.videocourseservice.model.Lesson;

public interface LessonRepository extends MongoRepository<Lesson, String> {
}
