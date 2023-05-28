package ru.lk.task20.videocourseservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.lk.task20.videocourseservice.model.Course;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course, String> {
     Course getCoursesBySubDirection(String subDirection);
     List<Course> getCoursesBySubDirectionIn(List<String> subDirectionList);
}
