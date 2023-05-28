package ru.hack.administrationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.administrationservice.models.user.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByOrderByXpDesc();
    User findUserById(String id);
}
