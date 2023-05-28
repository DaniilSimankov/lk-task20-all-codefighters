package ru.hack.schoolservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    private String studentId;

    private String name;
    private String reviewText;
    private int score;
}
