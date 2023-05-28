package ru.lk.task20.newsservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.lk.task20.newsservice.model.content.NewsContent;


@Document(collection = "news")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class News {
    @Id
    private String id;
    private String rubric;
    private String title;
    private NewsContent content;
}