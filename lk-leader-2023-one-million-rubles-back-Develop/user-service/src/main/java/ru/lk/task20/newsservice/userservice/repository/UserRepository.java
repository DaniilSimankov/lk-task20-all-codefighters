package ru.lk.task20.newsservice.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.lk.task20.newsservice.userservice.model.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByOrderByXpDesc();
    User findUserById(String id);
}
