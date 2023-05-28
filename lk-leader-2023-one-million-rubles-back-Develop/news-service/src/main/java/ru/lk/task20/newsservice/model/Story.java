package ru.lk.task20.newsservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Story {
    @Id
    private String id;
    private String name;
    private String photoUrl;
}
