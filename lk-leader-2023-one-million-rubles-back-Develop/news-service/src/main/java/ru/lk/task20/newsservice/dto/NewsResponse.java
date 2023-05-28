package ru.lk.task20.newsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lk.task20.newsservice.model.content.NewsContent;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse {
    private String id;
    private String title;
    private String rubric;
    private NewsContent content;
}
