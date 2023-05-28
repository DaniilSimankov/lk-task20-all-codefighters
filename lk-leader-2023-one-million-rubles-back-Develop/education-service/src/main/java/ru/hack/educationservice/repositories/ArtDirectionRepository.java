package ru.hack.educationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.educationservice.models.ArtDirection;

public interface ArtDirectionRepository extends MongoRepository<ArtDirection, String> {
}
