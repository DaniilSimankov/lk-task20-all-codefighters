package ru.lk.task20.newsservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.lk.task20.newsservice.dto.RubricResponse;
import ru.lk.task20.newsservice.model.Rubric;

import java.util.Arrays;
import java.util.List;


/**
 * Service for working with rubrics.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RubricService {

    /**
     * Get all rubrics.
     *
     * @return the list of all rubrics
     */
    public List<RubricResponse> getAllRubrics() {
        return Arrays.stream(Rubric.values())
                .map(this::mapToRubricResponse)
                .toList();
    }

    //HELP METHODS


    /**
     * Map the Rubric enum to the RubricResponse object.
     *
     * @param rubric the Rubric enum
     * @return the object with rubric information
     */
    private RubricResponse mapToRubricResponse(Rubric rubric) {
        return RubricResponse.builder()
                .title(rubric.getTitle())
                .abbr(rubric.getAbbr())
                .build();
    }
}
