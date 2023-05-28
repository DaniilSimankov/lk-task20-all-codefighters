package ru.lk.task20.authserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.lk.task20.authserver.model.User;

public interface UserCredentialsRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
