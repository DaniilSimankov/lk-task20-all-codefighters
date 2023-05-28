package ru.hack.educationservice.exception;

import lombok.NonNull;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(@NonNull String id) {
        super("Could student with id "+ id);
    }
}
