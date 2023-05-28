package ru.hack.schoolservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.hack.schoolservice.models.Age;
import ru.hack.schoolservice.models.FormOfTraining;
import ru.hack.schoolservice.models.Review;
import ru.hack.schoolservice.dto.SchoolDto;
import ru.hack.schoolservice.services.SchoolService;

import java.util.List;

@RestController
@RequestMapping("/api/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    //TODO: CompletableFuture.supplyAsync

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<SchoolDto> getAllSchool(){
        return schoolService.getAllSchool();
    }

    @GetMapping("/{school_id}")
    @ResponseStatus(HttpStatus.OK)
    public SchoolDto getSchoolById(@PathVariable("school_id") String schoolId){
        return schoolService.getSchoolById(schoolId);
    }

    @GetMapping("/county")
    @ResponseStatus(HttpStatus.OK)
    public List<SchoolDto> findSchoolsByCounty(@RequestParam("value") List<String> county){
        return schoolService.findSchoolsByCounty(county);
    }

    @GetMapping("/district")
    @ResponseStatus(HttpStatus.OK)
    public List<SchoolDto> findSchoolsByDistrict(@RequestParam("value")List<String> district){
        return schoolService.findSchoolsByDistrict(district);
    }

    @GetMapping("/artDirection")
    @ResponseStatus(HttpStatus.OK)
    public List<SchoolDto> findSchoolsByArtDirectionAbbreviatedTitle(@RequestParam("value") List<String> artDirectionNames){
        return schoolService.findSchoolsByArtDirectionAbbreviatedTitle(artDirectionNames);
    }

    @GetMapping("/subDirection")
    @ResponseStatus(HttpStatus.OK)
    public List<SchoolDto> findSchoolsBySubDirection(@RequestParam("value")List<String> subDirections){
        return schoolService.findSchoolsBySubDirection(subDirections);
    }

    @GetMapping("/coordinate")
    @ResponseStatus(HttpStatus.OK)
    public SchoolDto findSchoolByCoordinate(@RequestParam("value") String coordinate){
        return schoolService.findSchoolByCoordinate(coordinate);
    }

    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public List<SchoolDto> findSchoolByName(@RequestParam("value") String name){
        return schoolService.findSchoolsByName(name);
    }

    @PostMapping("/{schoolId}/reviews")
    public SchoolDto addReviewToSchool(@PathVariable("schoolId") String schoolId, @RequestBody Review review) {
        return schoolService.addReviewToSchool(schoolId, review);
    }

    @GetMapping("/filter")
    public List<SchoolDto> findSchoolsByField(@RequestParam(value = "age", required = false) List<String> ages,
                                              @RequestParam(value = "formOfTraining", required = false) List<String> formOfTrainings,
                                              @RequestParam(value = "county", required = false) List<String> county,
                                              @RequestParam(value = "district", required = false) List<String> district,
                                              @RequestParam(value = "subDirections", required = false) List<String> subDirections){
        return schoolService.findSchoolsByFields(ages, formOfTrainings, county, district, subDirections);
    }


}
