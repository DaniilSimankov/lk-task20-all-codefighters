package ru.lk.task20.newsservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "art_directions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ArtDirection {
    @Id
    private String id;
    private String abbreviatedTitle;
    private String name;
    private List<String> subDirections;
    //TODO SCHOOLS
}