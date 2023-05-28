package ru.hack.artdirectionservice.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.hack.artdirectionservice.models.ArtDirection;
import ru.hack.artdirectionservice.repositories.ArtDirectionRepository;

import java.util.List;

/**
 * Service class for managing art directions.
 *
 * This class provides methods to retrieve art directions from the repository.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ArtDirectionServices {

    private final ArtDirectionRepository artDirectionRepository;

    /**
     * Retrieves all art directions.
     *
     * This method retrieves all art directions from the repository and returns a list of {@link ArtDirection} objects
     * representing the art directions.
     *
     * @return A list of {@link ArtDirection} objects representing all art directions.
     */
    public List<ArtDirection> getAllArtDirections() {
        return artDirectionRepository.findAll();
    }

    /**
     * Retrieves an art direction by its abbreviation.
     *
     * This method retrieves the art direction with the specified abbreviation from the repository and returns an
     * {@link ArtDirection} object representing the art direction.
     *
     * @param abbr The abbreviation of the art direction.
     * @return The {@link ArtDirection} object representing the art direction with the specified abbreviation.
     * @throws IllegalArgumentException if the provided abbreviation is null.
     */
    public ArtDirection getArtDirectionByAbbreviate(@NonNull String abbr) {
        return artDirectionRepository.findByAbbreviatedTitle(abbr);
    }
}
