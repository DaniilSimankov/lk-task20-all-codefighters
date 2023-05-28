package ru.hack.educationservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test_results")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TestResult {
    @Id
    private String id;

    private String testId;
    private  String studentId;

    private int ball;
    private Double percent;
}
