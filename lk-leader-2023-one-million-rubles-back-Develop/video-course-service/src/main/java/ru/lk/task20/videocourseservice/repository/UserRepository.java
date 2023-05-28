package ru.lk.task20.videocourseservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.lk.task20.videocourseservice.model.User;

public interface UserRepository extends MongoRepository<User, String> {
}
