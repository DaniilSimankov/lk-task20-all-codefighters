package ru.hack.schoolservice.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.hack.schoolservice.dto.ReviewDto;
import ru.hack.schoolservice.models.Age;
import ru.hack.schoolservice.models.FormOfTraining;
import ru.hack.schoolservice.models.Review;
import ru.hack.schoolservice.dto.SchoolDto;
import ru.hack.schoolservice.exceptions.SchoolNotFoundByCoordinateException;
import ru.hack.schoolservice.exceptions.SchoolNotFoundByIdException;
import ru.hack.schoolservice.models.School;
import ru.hack.schoolservice.repositories.SchoolRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ru.hack.schoolservice.models.School.calculateCurrentScore;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolDto getSchoolById(@NonNull String id){
        return SchoolDto.from(schoolRepository.findById(id).orElseThrow(()-> new SchoolNotFoundByIdException(id)));
    }

    public List<SchoolDto> findSchoolsByCounty(@NonNull List<String> countys) {
        return SchoolDto.from(schoolRepository.findSchoolsByCountyIn(countys));
    }

    public List<SchoolDto> findSchoolsByDistrict(@NonNull List<String> districts) {
        return SchoolDto.from(schoolRepository.findSchoolsByDistrictIn(districts));
    }

    public List<SchoolDto> findSchoolsByArtDirectionAbbreviatedTitle(@NonNull List<String> abbreviatedTitles) {
        return SchoolDto.from(schoolRepository.findSchoolsByArtDirectionsAbbreviatedTitle(abbreviatedTitles));
    }

    public SchoolDto findSchoolByCoordinate(@NonNull String coordinate) {
        return  SchoolDto.from(schoolRepository.findByCoordinate(coordinate).orElseThrow(()-> new SchoolNotFoundByCoordinateException(coordinate)));
    }

    //TODO: пагинация
    public List<SchoolDto> getAllSchool() {
        return SchoolDto.from(schoolRepository.findAll());
    }

    public List<SchoolDto> findSchoolsBySubDirection(List<String> subDirections) {
        return SchoolDto.from(schoolRepository.findSchoolsBySubDirections(subDirections));
    }

    public List<SchoolDto> findSchoolsByName(@NonNull String name) {
        return SchoolDto.from(schoolRepository.findSchoolsByNameContainingIgnoreCase(name));
    }

    // TODO добавить проверку на существование юзера
    public SchoolDto addReviewToSchool(@NonNull String schoolId, @NonNull Review review) {
        School school = schoolRepository.findById(schoolId).orElseThrow(()-> new SchoolNotFoundByIdException(schoolId));

        if (review.getScore() >= 1) {
            if(review.getScore() > 5){
                review.setScore(5);
            }
        } else {
            review.setScore(1);
        }

        school.getReviews().put(review.getStudentId(), ReviewDto.from(review));
        school.getCountScoresByNumber().put(review.getScore(), school.getCountScoresByNumber().get(review.getScore())==null ? 1 : school.getCountScoresByNumber().get(review.getScore())+1);
        school.setCurrentScore(calculateCurrentScore(school.getReviews()));
        return SchoolDto.from(schoolRepository.save(school));
    }

    public List<SchoolDto> findSchoolsByFields(List<String> ages, List<String> formOfTrainings, List<String> county, List<String> district, List<String> subDirections){

        if(ages==null && formOfTrainings==null && county ==null && district==null &&subDirections==null)
            return getAllSchool();

        Set<School> response = new HashSet<>();

        if(ages!=null)
            response.addAll(schoolRepository.findSchoolsByAges(ages));
        if(formOfTrainings!=null)
            response.addAll(schoolRepository.findSchoolsByFormOfTrainings(formOfTrainings));
        if(county!=null)
            response.addAll(schoolRepository.findSchoolsByCountyIn(county));
        if(district!=null)
            response.addAll(schoolRepository.findSchoolsByDistrictIn(district));
        if(subDirections!=null)
            response.addAll(schoolRepository.findSchoolsBySubDirections(subDirections));

        return SchoolDto.from(response.stream().toList());
    }

}
