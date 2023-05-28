package ru.hack.administrationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.administrationservice.models.user.Friendship;

import java.util.List;

public interface FriendshipRepository extends MongoRepository<Friendship, String> {
    Friendship findFriendshipById(String id);
    List<Friendship> getFriendshipsByIdTo(String id);
    List<Friendship> getFriendshipsByIdFrom(String id);
}
