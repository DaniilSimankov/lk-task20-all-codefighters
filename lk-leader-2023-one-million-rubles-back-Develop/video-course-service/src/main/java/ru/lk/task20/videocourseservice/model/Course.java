package ru.lk.task20.videocourseservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Course {
    @Id
    private String id;
    private String name;
    private TeacherInfo teacherInfo;
    private List<String> lessonIds;
    private String description;
    private String artDirection;
    private String subDirection;
}
