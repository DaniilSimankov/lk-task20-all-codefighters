package ru.hack.educationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.educationservice.models.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}

