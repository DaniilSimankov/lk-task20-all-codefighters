package ru.hack.educationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.educationservice.models.Test;

import java.util.List;

public interface TestRepository extends MongoRepository<Test, String> {

    List<Test> findAllByArtDirection(String artDirection);
}
