package ru.hack.administrationservice.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hack.administrationservice.models.school.ArtDirection;
import ru.hack.administrationservice.models.test.Student;
import ru.hack.administrationservice.repositories.ArtDirectionRepository;
import ru.hack.administrationservice.repositories.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    // for test
    public Student saveStudent(@NonNull Student student) {
        return studentRepository.save(student);
    }

    private final ArtDirectionRepository artDirectionRepository;


    public ArtDirection saveArtDirection(@NonNull ArtDirection artDirection) {
        return artDirectionRepository.save(artDirection);
    }
}
