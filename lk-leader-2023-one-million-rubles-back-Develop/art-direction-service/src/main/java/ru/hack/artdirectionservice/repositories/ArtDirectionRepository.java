package ru.hack.artdirectionservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.hack.artdirectionservice.models.ArtDirection;

public interface ArtDirectionRepository extends MongoRepository<ArtDirection, String> {

    ArtDirection findByAbbreviatedTitle(String abbr);
}
