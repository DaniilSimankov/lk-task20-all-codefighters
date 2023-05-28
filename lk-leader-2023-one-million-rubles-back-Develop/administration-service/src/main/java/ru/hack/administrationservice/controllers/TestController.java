package ru.hack.administrationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.hack.administrationservice.models.school.ArtDirection;
import ru.hack.administrationservice.models.test.Student;
import ru.hack.administrationservice.models.test.Test;
import ru.hack.administrationservice.repositories.ArtDirectionRepository;
import ru.hack.administrationservice.repositories.StudentRepository;
import ru.hack.administrationservice.repositories.TestRepository;

@RestController
@RequestMapping("/api/helper")
@RequiredArgsConstructor
public class TestController {

    private final ArtDirectionRepository artDirectionRepository;
    private final TestRepository testRepository;
    private final StudentRepository studentRepository;

    @PostMapping("/test")
    public Test createTest(@RequestBody Test test){
        return testRepository.save(test);
    }

    @PostMapping("/direction")
    @ResponseStatus(HttpStatus.CREATED)
    public ArtDirection saveAd(@RequestBody ArtDirection artDirection) {
        return artDirectionRepository.save(artDirection);
    }

    @PostMapping("/student/direction")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addAdToStudent(@RequestParam  String id, @RequestParam String ad) {
        ArtDirection artDirection = artDirectionRepository.findById(ad).get();
        Student student = studentRepository.findById(id).get();
        student.getArtDirections().add(artDirection);

        return studentRepository.save(student);
    }
}
