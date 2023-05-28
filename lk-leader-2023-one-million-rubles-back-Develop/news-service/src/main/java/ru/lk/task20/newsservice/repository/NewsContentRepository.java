package ru.lk.task20.newsservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.lk.task20.newsservice.model.content.NewsContent;

public interface NewsContentRepository extends MongoRepository<NewsContent, String> {

}
