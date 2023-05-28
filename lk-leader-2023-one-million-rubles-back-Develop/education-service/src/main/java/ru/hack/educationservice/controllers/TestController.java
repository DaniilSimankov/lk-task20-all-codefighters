package ru.hack.educationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.hack.educationservice.dto.StudentArtTestDTO;
import ru.hack.educationservice.dto.TestDto;
import ru.hack.educationservice.models.Test;
import ru.hack.educationservice.services.TestService;

import java.util.List;

@RestController
@RequestMapping("/api/education/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TestDto> getTestsByCategory(@RequestBody StudentArtTestDTO studentArtTestDTO){
        return testService.getTestsInCategory(studentArtTestDTO.getArtDirection(), studentArtTestDTO.getStudentId());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Test getTestById(@PathVariable(name = "id") String id){
        System.out.println(id);
        return testService.getTestById(id);
    }

}
