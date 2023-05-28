package ru.hack.schoolservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.hack.schoolservice.models.Age;
import ru.hack.schoolservice.models.FormOfTraining;
import ru.hack.schoolservice.models.School;

import java.util.List;
import java.util.Optional;

public interface SchoolRepository extends MongoRepository<School, String> {

    // for Map
    @Query(value = "{ 'county' : { $in : ?0 } }")
    List<School> findSchoolsByCountyIn(List<String> county);

    @Query(value = "{ 'district' : { $in : ?0 } }")
    List<School> findSchoolsByDistrictIn(List<String> district);

    Optional<School> findByCoordinate(String coordinate);

    List<School> findSchoolsByNameContainingIgnoreCase(String name);

    // for filter in All School
    @Query(value = "{ 'artDirections.abbreviatedTitle' : { $in : ?0 } }")
    List<School> findSchoolsByArtDirectionsAbbreviatedTitle(@Param("abbreviatedTitle") List<String> artDirectionAbbreviatedTitle);

    @Query(value = "{ 'age' : { $in : ?0 } }")
    List<School> findSchoolsByAges(@Param("ages") List<String> ages);

    @Query(value = "{ 'formOfTrainings' : { $in : ?0 } }")
    List<School> findSchoolsByFormOfTrainings(@Param("formOfTrainings") List<String> formOfTrainings);

    @Query(value = "{ 'artDirections.subDirections' : { $in : ?0 } }")
    List<School> findSchoolsBySubDirections(@Param("subDirectionNames") List<String> subDirectionNames);

}
