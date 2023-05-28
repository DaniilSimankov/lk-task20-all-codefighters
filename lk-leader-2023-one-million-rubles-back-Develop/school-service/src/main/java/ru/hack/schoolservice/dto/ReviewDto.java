package ru.hack.schoolservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hack.schoolservice.models.Review;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private String name;
    private String reviewText;
    private int score;

    public static ReviewDto from(Review review){
        return ReviewDto.builder()
                .name(review.getName())
                .reviewText(review.getReviewText())
                .score(review.getScore())
                .build();
    }
}
