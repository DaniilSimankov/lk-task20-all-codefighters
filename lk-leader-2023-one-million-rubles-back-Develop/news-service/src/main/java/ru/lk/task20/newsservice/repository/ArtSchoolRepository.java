package ru.lk.task20.newsservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.lk.task20.newsservice.model.ArtSchool;

import java.util.List;

public interface ArtSchoolRepository extends MongoRepository<ArtSchool, String> {
    List<ArtSchool> findArtSchoolsBySubDirectionsIn(List<String> subDirections);
}
