package ru.lk.task20.newsservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.lk.task20.newsservice.model.Story;

public interface StoryRepository extends MongoRepository<Story, String> {
}
