package ru.hack.artdirectionservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hack.artdirectionservice.models.ArtDirection;
import ru.hack.artdirectionservice.services.ArtDirectionServices;

import java.util.List;

/**
 * Controller class for managing art directions.
 *
 * This class handles incoming HTTP requests related to art directions and delegates the processing to the
 * {@link ArtDirectionServices} service class.
 */
@RestController
@RequestMapping("/api/art-direction")
@RequiredArgsConstructor
public class ArtDirectionController {

    private final ArtDirectionServices artDirectionServices;

    /**
     * Retrieves all art directions.
     *
     * This method handles the HTTP GET request to "/api/art-direction" and returns a list of {@link ArtDirection}
     * objects representing all art directions.
     *
     * @return A list of {@link ArtDirection} objects representing all art directions.
     */
    @GetMapping
    public List<ArtDirection> getAllArtDirections(){
        return artDirectionServices.getAllArtDirections();
    }

    /**
     * Retrieves an art direction by its abbreviation.
     *
     * This method handles the HTTP GET request to "/api/art-direction" with the query parameter "abbr" specifying
     * the abbreviation of the art direction. It retrieves the art direction with the specified abbreviation and returns
     * an {@link ArtDirection} object representing the art direction.
     *
     * @param abbr The abbreviation of the art direction.
     * @return The {@link ArtDirection} object representing the art direction with the specified abbreviation.
     */
    @GetMapping("/name")
    public ArtDirection getArtDirectionByAbbreviate(@RequestParam("abbr") String abbr){
        return artDirectionServices.getArtDirectionByAbbreviate(abbr);
    }
}
