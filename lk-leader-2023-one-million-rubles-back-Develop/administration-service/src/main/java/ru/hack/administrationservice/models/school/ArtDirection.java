package ru.hack.administrationservice.models.school;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
