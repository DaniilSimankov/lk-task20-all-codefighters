package ru.hack.schoolservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.schoolservice.models.ArtDirection;

import java.util.Optional;

public interface ArtDirectionRepository extends MongoRepository<ArtDirection, String> {

    Optional<ArtDirection> findArtDirectionByName(String name);
}
