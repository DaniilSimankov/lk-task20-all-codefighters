package ru.lk.task20.newsservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.lk.task20.newsservice.model.ArtDirection;

public interface ArtDirectionRepository extends MongoRepository<ArtDirection, String> {
    ArtDirection findArtDirectionByAbbreviatedTitle(String abbreviatedTitle);
}
