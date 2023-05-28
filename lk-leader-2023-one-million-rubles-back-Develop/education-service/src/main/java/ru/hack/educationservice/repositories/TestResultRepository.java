package ru.hack.educationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.educationservice.models.TestResult;

import java.util.List;

public interface TestResultRepository extends MongoRepository<TestResult, String> {

    List<TestResult> findAllByStudentId(String idStudent);
}
