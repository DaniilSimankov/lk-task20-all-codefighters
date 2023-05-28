package ru.hack.educationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hack.educationservice.models.Test;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestDto {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private String artDirection;
    private boolean isCompleted;

    public static TestDto from(Test test){
        return TestDto.builder()
                .id(test.getId())
                .name(test.getName())
                .artDirection(test.getArtDirection())
                .description(test.getDescription())
                .imageUrl(test.getImageUrl())
                .build();
    }

    public static List<TestDto> from(List<Test> tests){
        return tests.stream().map(TestDto::from).toList();
    }
}
