package ru.hack.administrationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.administrationservice.models.school.ArtDirection;

import java.util.Optional;

public interface ArtDirectionRepository extends MongoRepository<ArtDirection, String> {

    Optional<ArtDirection> findArtDirectionByName(String name);
}
