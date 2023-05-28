package ru.hack.educationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.hack.educationservice.dto.ResultInfo;
import ru.hack.educationservice.models.TestResult;
import ru.hack.educationservice.services.ResultService;

@RestController
@RequestMapping("/api/education/test")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;

    @PostMapping("/result")
    @ResponseStatus(HttpStatus.CREATED)
    public TestResult saveResult(@RequestBody ResultInfo resultInfo){
        return resultService.saveResult(resultInfo);
    }
}
