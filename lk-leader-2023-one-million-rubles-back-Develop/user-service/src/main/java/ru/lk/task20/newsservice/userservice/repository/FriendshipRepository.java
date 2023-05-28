package ru.lk.task20.newsservice.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.lk.task20.newsservice.userservice.model.Friendship;

import java.util.List;

public interface FriendshipRepository extends MongoRepository<Friendship, String> {
    Friendship findFriendshipById(String id);
    List<Friendship> getFriendshipsByIdTo(String id);
    List<Friendship> getFriendshipsByIdFrom(String id);
}
