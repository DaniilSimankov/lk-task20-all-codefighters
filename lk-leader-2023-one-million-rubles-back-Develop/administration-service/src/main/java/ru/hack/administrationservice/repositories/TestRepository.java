package ru.hack.administrationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.administrationservice.models.test.Test;

import java.util.List;

public interface TestRepository extends MongoRepository<Test, String> {

    List<Test> findAllByArtDirection(String artDirection);
}
