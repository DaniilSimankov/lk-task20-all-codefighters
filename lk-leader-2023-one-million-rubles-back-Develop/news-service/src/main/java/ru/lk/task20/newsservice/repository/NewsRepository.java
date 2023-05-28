package ru.lk.task20.newsservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.lk.task20.newsservice.model.News;
import ru.lk.task20.newsservice.model.Rubric;

import java.util.List;

public interface NewsRepository extends MongoRepository<News, String> {
    List<News> getAllByRubric(String rubric);
    News getNewsById(String id);
}
