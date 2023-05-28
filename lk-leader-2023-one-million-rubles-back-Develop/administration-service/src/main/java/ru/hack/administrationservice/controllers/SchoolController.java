package ru.hack.administrationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.hack.administrationservice.models.school.Event;
import ru.hack.administrationservice.models.school.School;
import ru.hack.administrationservice.repositories.ArtDirectionRepository;
import ru.hack.administrationservice.repositories.EventRepository;
import ru.hack.administrationservice.repositories.SchoolRepository;

import java.util.List;

@RestController
@RequestMapping("/api/helper")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolRepository schoolRepository;
    private final ArtDirectionRepository artDirectionRepository;
    private final EventRepository eventRepository;

    @PostMapping("/school")
    @ResponseStatus(HttpStatus.CREATED)
    public School createSchool(@RequestBody School school) {
        return schoolRepository.save(school);
    }

    @PostMapping("/school/art")
    public School addArtDirectionToSchool(@RequestParam("artDir") String artDir, @RequestParam("subDirs") List<String> subDirs, @RequestParam("school") String id) {
//        School school = schoolRepository.findById(id).get();
//        ArtDirection artDirection = artDirectionRepository.findArtDirectionByName(artDir).get();
//        school.getArtDirections().add(artDir);
//        school.getSubDirections().addAll(subDirs);
//        school.getArtDirectionsImagesUrls().putIfAbsent(artDir, artDirection.getImageUrl());
//        school.getArtDirectionsWithSubDirections().putIfAbsent(artDir, subDirs);
//        schoolRepository.save(school);
        return null;
    }

    @PostMapping("/event")
    public School addEventToSchool(@RequestBody Event event, @RequestParam("school_id") String id) {
        School school = schoolRepository.findById(id).get();
        event = eventRepository.save(event);
        school.getEvents().add(event);
        return schoolRepository.save(school);
    }

}
