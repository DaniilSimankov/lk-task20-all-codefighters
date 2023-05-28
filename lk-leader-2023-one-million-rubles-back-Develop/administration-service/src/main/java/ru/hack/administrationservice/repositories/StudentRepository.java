package ru.hack.administrationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.administrationservice.models.test.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}

