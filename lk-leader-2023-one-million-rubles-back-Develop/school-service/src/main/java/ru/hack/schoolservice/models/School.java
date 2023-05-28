package ru.hack.schoolservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.hack.schoolservice.dto.ReviewDto;

import java.util.HashMap;
import java.util.List;

@Document(collection = "art_schools")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class School {
    @Id
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private List<String> imageUrls;
    private String siteUrl;
    private String description;

    private List<Age> age;
    private List<FormOfTraining> formOfTraining;

    private String coordinate;
    private String county;
    private String district;

    private List<ArtDirection> artDirections;
    private List<Event> events;

    private double currentScore;
    private HashMap<String, ReviewDto> reviews;
    private HashMap<Integer, Integer> countScoresByNumber;

    public static double calculateCurrentScore(HashMap<String, ReviewDto> reviews) {
        if (reviews.isEmpty()) {
            return 0;
        }

        int totalScore = reviews.values().stream()
                .mapToInt(ReviewDto::getScore)
                .sum();

        return (double) totalScore / reviews.size();
    }


}

/*

- Карта Московских школ искусств
Отрисованная интерактивная карта Москвы с нанесенными
образовательными учреждениями. При нажатии на значок интересующей
школы должна появляться справочная информация по форме: название
учреждения, адрес, телефон, почта, краткое описание, особенности,
реализуемые направления обучения.
В карте должен быть доступен поиск по округу, району, направлению
(фильтры). Доступно определение геолокации, с отображением рядом
расположенных учреждений.


 */