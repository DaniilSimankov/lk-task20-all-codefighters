package ru.lk.task20.newsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoArtDirectionResponse {
    private String name;
    private String abbreviatedTitle;
    private List<String> subDirections;
}
