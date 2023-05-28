package ru.hack.educationservice.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hack.educationservice.dto.ResultInfo;
import ru.hack.educationservice.exception.StudentNotFoundException;
import ru.hack.educationservice.exception.TestNotFoundException;
import ru.hack.educationservice.models.Student;
import ru.hack.educationservice.models.Test;
import ru.hack.educationservice.models.TestResult;
import ru.hack.educationservice.repositories.StudentRepository;
import ru.hack.educationservice.repositories.TestRepository;
import ru.hack.educationservice.repositories.TestResultRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final TestResultRepository testResultRepository;
    private final StudentRepository studentRepository;
    private final TestRepository testRepository;

    public final TestResult saveResult(@NonNull ResultInfo resultInfo) {

        Test test = testRepository.findById(resultInfo.getTestId()).orElseThrow(() -> {
            throw new TestNotFoundException(resultInfo.getTestId());
        });
        Student student = studentRepository.findById(resultInfo.getStudentId()).orElseThrow(() -> {
            throw new StudentNotFoundException(resultInfo.getStudentId());
        });

        if (resultInfo.getBall() > test.getMaxBall())
            resultInfo.setBall(test.getMaxBall());

        TestResult testResult = TestResult.builder()
                .testId(resultInfo.getTestId())
                .studentId(resultInfo.getStudentId())
                .ball(resultInfo.getBall())
                .percent((double) resultInfo.getBall() / test.getMaxBall())
                .build();

        return testResultRepository.save(testResult);
    }
}
