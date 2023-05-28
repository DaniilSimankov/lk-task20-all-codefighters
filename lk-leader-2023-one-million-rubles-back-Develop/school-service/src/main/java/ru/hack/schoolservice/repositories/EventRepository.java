package ru.hack.schoolservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.schoolservice.models.Event;

public interface EventRepository extends MongoRepository<Event, String> {
}
