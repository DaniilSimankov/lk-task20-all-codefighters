package ru.lk.task20.newsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lk.task20.newsservice.model.ArtSchool;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArtDirectionResponse {
    private String name;
    private List<ArtSchool> artSchools;
//    private String description;
}
