package ru.hack.schoolservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hack.schoolservice.models.*;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SchoolDto {
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
    private HashMap<String, ReviewDto> reviewDtos;
    private HashMap<Integer, Integer> countScoresByNumber;

    private double currentScore;

    public static SchoolDto from(School school){
        return SchoolDto.builder()
                .id(school.getId())
                .name(school.getName())
                .address(school.getAddress())
                .phoneNumber(school.getPhoneNumber())
                .email(school.getEmail())
                .imageUrls(school.getImageUrls())
                .siteUrl(school.getSiteUrl())
                .description(school.getDescription())
                .coordinate(school.getCoordinate())
                .county(school.getCounty())
                .district(school.getDistrict())
                .artDirections(school.getArtDirections())
                .events(school.getEvents())
                .reviewDtos(school.getReviews())
                .currentScore(school.getCurrentScore())
                .countScoresByNumber(school.getCountScoresByNumber())
                .age(school.getAge())
                .formOfTraining(school.getFormOfTraining())
                .build();
    }

    public static List<SchoolDto> from(List<School> schools){
        return schools.stream().map(SchoolDto::from).toList();
    }
}
