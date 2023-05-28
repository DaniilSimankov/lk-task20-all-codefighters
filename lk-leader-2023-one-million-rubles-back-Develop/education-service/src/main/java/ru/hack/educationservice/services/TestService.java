package ru.hack.educationservice.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.hack.educationservice.dto.TestDto;
import ru.hack.educationservice.exception.TestNotFoundException;
import ru.hack.educationservice.models.Test;
import ru.hack.educationservice.models.TestResult;
import ru.hack.educationservice.repositories.TestRepository;
import ru.hack.educationservice.repositories.TestResultRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    private final TestRepository testRepository;
    private final TestResultRepository testResultRepository;

    public List<TestDto> getTestsInCategory(@NonNull String artDirection, String studentId) {
        List<TestDto> tests = TestDto.from(testRepository.findAllByArtDirection(artDirection));
        List<TestResult> results = testResultRepository.findAllByStudentId(studentId);

        tests.forEach(test -> test.setCompleted(results.stream().anyMatch(result -> result.getTestId().equals(test.getId()))));

        return tests;
    }


    public Test getTestById(@NonNull String id) {
        Optional<Test> test = testRepository.findById(id);
        if(test.isEmpty()){
            throw new TestNotFoundException(id);
        }
        return test.get();
    }

}
