package ru.hack.administrationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.hack.administrationservice.models.school.School;

import java.util.List;
import java.util.Optional;

public interface SchoolRepository extends MongoRepository<School, String> {

    // for Map
    List<School> findSchoolsByCounty(String county);

    List<School> findSchoolsByDistrict(String district);

    Optional<School> findByCoordinate(String coordinate);

    List<School> findSchoolsByNameContainingIgnoreCase(String name);

    // for filter in All School
    @Query(value = "{ 'artDirections.name' : { $in : ?0 } }")
    List<School> findSchoolsByArtDirectionsNames(@Param("artDirectionNames") List<String> artDirectionNames);

    @Query(value = "{ 'artDirections.subDirections' : { $in : ?0 } }")
    List<School> findSchoolsBySubDirections(@Param("subDirectionNames") List<String> subDirectionNames);


}
