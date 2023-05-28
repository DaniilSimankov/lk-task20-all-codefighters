package ru.hack.administrationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.administrationservice.models.school.Event;

public interface EventRepository extends MongoRepository<Event, String> {
}
