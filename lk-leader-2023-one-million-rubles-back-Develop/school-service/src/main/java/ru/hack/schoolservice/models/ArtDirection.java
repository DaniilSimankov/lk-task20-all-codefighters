package ru.hack.schoolservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


//@Document(collection = "art_directions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ArtDirection {
    private String abbreviatedTitle;
    private String name;
    private String imageUrl;
    private List<String> subDirections;
}
