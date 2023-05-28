package ru.lk.task20.videocourseservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lessons")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Lesson {
    @Id
    private String id;
    private String name;
    private String videoUrl;
    private boolean isPreview;
    private boolean isExtra;
}
