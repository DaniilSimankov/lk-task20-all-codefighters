package ru.lk.task20.newsservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lk.task20.newsservice.dto.RubricResponse;
import ru.lk.task20.newsservice.service.RubricService;

import java.util.List;

/**
 * Controller for managing rubrics.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news/rubrics")
public class RubricController {

    private final RubricService rubricService;

    /**
     * Get all rubrics.
     *
     * @return the list of all rubrics
     */
    @GetMapping
    private List<RubricResponse> getAllRubrics() {
        return rubricService.getAllRubrics();
    }
}
