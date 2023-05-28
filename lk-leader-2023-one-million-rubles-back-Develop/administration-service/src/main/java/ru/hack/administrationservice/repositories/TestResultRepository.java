package ru.hack.administrationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.administrationservice.models.test.TestResult;

public interface TestResultRepository extends MongoRepository<TestResult, String> {
}
