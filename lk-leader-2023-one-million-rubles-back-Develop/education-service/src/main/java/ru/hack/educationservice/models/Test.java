package ru.hack.educationservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.hack.educationservice.models.questions.Question;

import java.util.List;

@Document(collection = "tests")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Test {
    @Id
    private String id;

    private String name;
    private String description;
    private String imageUrl;
    private String artDirection;

    private Integer maxBall;

    private List<Question> questions;
}
